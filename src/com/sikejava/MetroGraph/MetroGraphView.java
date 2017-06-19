package com.sikejava.MetroGraph;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/********************************************************************************
 * MetroGraph --
 * @version 2017/06/13 16:02
 * @author 西唐王, xtwyzh@gmail.com,xtwroot.com
 * xtwroot Copyrights (c) 2017. All rights reserved.
 ********************************************************************************/

enum Strategy { MIN_TIME , MIN_TRANS };



class MetroGraphView extends JPanel implements MouseListener, MouseWheelListener, MouseMotionListener {

    private MetroGraph mGraph = new MetroGraph();
    private int mScrollX;
    private int mScrollY;
    private float mZoomScale;
    private MetroNode mStartNode;
    private MetroNode mEndNode;
    private Point mMouseLastPoint = null;
    private ArrayList<MetroNode> mPathNodes = null;
    private Strategy mStrategy = Strategy.MIN_TRANS;

    /**
     * 构造
     */
    MetroGraphView() {

        this.addMouseListener(this);
        this.addMouseWheelListener(this);
        this.addMouseMotionListener(this);

        final JPopupMenu jp = new JPopupMenu();
        JRadioButtonMenuItem item = new JRadioButtonMenuItem("\u6700\u5c11\u65f6\u95f4");
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                mStrategy = Strategy.MIN_TIME;
                FindPath();
            }
        });
        jp.add(item);
        item = new JRadioButtonMenuItem("\u6700\u5c11\u6362\u4e58");
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                mStrategy = Strategy.MIN_TRANS;
                FindPath();
            }
        });
        jp.add(item);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    // 弹出菜单
                    jp.show(MetroGraphView.this, e.getX(), e.getY());
                }
            }
        });
        this.setVisible(true);

        OpenFromXml("info\\MetroGraph.xml");
        mZoomScale = 0.3f;
    }

    /**
     * 重写OnPaint方法。
     *
     * @param graphics
     */
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setColor(new Color(255, 255, 255));
        graphics2D.fillRect(0, (int) 0, 10000, 10000);



        File sourceimage = new File("info\\line.jpg");

        Image startImage = null;
        try {
            startImage = ImageIO.read(sourceimage);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int sx = 10;
        int sy = 10;
        graphics2D.scale(0.5, 0.5);
        graphics2D.drawImage(startImage, sx, sy, this);
        graphics2D.scale(2,2);
        graphics2D.translate(mScrollX, mScrollY);
        graphics2D.scale(mZoomScale, mZoomScale);
        Font font = new Font("宋体", Font.PLAIN, 30);
        graphics2D.setFont(font);
        PaintGraph(graphics2D, mGraph);

        PaintCurPath(graphics2D);
        PaintStartAndEndNodes(graphics2D);
    }

    /**
     * 绘制当前乘车路线。
     *
     * @param graphics2D
     */
    private void PaintCurPath(Graphics2D graphics2D) {

        if(mPathNodes != null && mPathNodes.size() != 0) {
            Rectangle rectangle = this.getBounds();
            graphics2D.setColor(new Color(255, 255, 255, 200));
            graphics2D.fillRect((int) rectangle.getX(), (int) rectangle.getY(), 18000, 16000);
            for(int i = 0;i < mPathNodes.size() - 1;++i) {
                PaintLink(graphics2D,mPathNodes.get(i),mPathNodes.get(i+1));
            }
            for (MetroNode node : mPathNodes) {
                PaintNode(graphics2D, node);
            }
        }
    }

    /**
     * 画线，通过点
     * @param graphics2D
     * @param startNode
     * @param endNode
     */
    private void PaintLink(Graphics2D graphics2D,MetroNode startNode,MetroNode endNode) {
        Point pt1 = new Point(startNode.getX(), startNode.getY());
        Point pt2 = new Point(endNode.getX(), endNode.getY());

        Stroke stroke = new BasicStroke(12.0f);
        graphics2D.setStroke(stroke);
        if(getSameLine(startNode,endNode) != null && Math.abs(pt1.x - pt2.x)< 400 && Math.abs(pt1.y - pt2.y)< 400)
        {
            graphics2D.setColor(getSameLine(startNode,endNode).getColor());

            graphics2D.drawLine(pt1.x, pt1.y, pt2.x, pt2.y);
        }

    }

    /**
     * 绘制地铁站点间的线路。
     *
     * @param graphics2D 绘图图面。
     * @param link       地铁站点间的线路。
     */
    private void PaintLink(Graphics2D graphics2D, MetroLink link) {

        Point pt1 = new Point(link.getFrom().getX(), link.getFrom().getY());
        Point pt2 = new Point(link.getTo().getX(), link.getTo().getY());

        Stroke stroke = new BasicStroke(12.0f);
        graphics2D.setStroke(stroke);
        graphics2D.setColor(link.getLine().getColor());

        graphics2D.drawLine(pt1.x, pt1.y, pt2.x, pt2.y);
    }

    /**
     * @param graphics2D
     */
    private void PaintStartAndEndNodes(Graphics2D graphics2D) {
        if (mStartNode != null) {

            try {
                // 绘制起点
                File sourceimage = new File("info\\StartNode.png");
                if (mStartNode != null) {
                    Image startImage = ImageIO.read(sourceimage);
                    int sx = mStartNode.getX() - startImage.getWidth(this) / 2;
                    int sy = mStartNode.getY() - startImage.getHeight(this);
                    graphics2D.drawImage(startImage, sx, sy, this);
                    updateUI();
                }

                // 绘制终点
                if (mEndNode != null) {
                    sourceimage = new File("info\\EndNode.png");
                    Image endImage = ImageIO.read(sourceimage);
                    int ex = mEndNode.getX() - endImage.getWidth(this) / 2;
                    int ey = mEndNode.getY() - endImage.getHeight(this);
                    graphics2D.drawImage(endImage, ex, ey, this);
                    updateUI();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param graphics2D
     * @param graph
     */
    private void PaintGraph(Graphics2D graphics2D, MetroGraph graph) {

        for (MetroLink link :
                graph.Links()) {
            if (link.getFlag() >= 0) {
                PaintLink(graphics2D, link);
            }
        }

        for (MetroNode node :
                graph.getNodes().values()) {
            PaintNode(graphics2D, node);
        }

    }

    /**
     * 绘制地铁站点。
     *
     * @param graphics2D 绘图图面。
     * @param node       地铁站点。
     */
    private void PaintNode(Graphics2D graphics2D, MetroNode node) {
        // 绘制站点圆圈
        Color color = node.getLinks().size() > 2 ? Color.black : node.getLinks().get(0).getLine().getColor();
        Rectangle rect = GetNodeRect(node);

        graphics2D.setColor(color);
        graphics2D.fillOval((int) rect.getX(), (int) rect.getY(), (int) rect.getWidth() + 6, (int) rect.getHeight() + 6);
        graphics2D.setColor(Color.white);
        graphics2D.fillOval((int) rect.getX() + 3, (int) rect.getY() + 3, (int) rect.getWidth(), (int) rect.getHeight());

        // 绘制站点名称
        graphics2D.setColor(Color.black);
        graphics2D.drawString(node.getName(), node.getX() - node.getName().length() * 14, node.getY() + 60);

    }

    /**
     * 获取地铁站点的矩形区域。
     *
     * @param node 地铁站点。
     * @return
     */
    private Rectangle GetNodeRect(MetroNode node) {
        int r = node.getLinks().size() > 2 ? 26 : 16;
        return new Rectangle(node.getX() - r, node.getY() - r, 2 * r, 2 * r);
    }

    /**
     * 从指定文件打开地铁线路图。
     *
     * @param fileName xml文件名。
     */
    public void OpenFromXml(String fileName) {
        if (fileName == null || fileName.isEmpty())
            return;

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(fileName);

            Element element = document.getDocumentElement();
            mScrollX = Integer.parseInt(element.getAttribute("ScrollX"));
            mScrollY = Integer.parseInt(element.getAttribute("ScrollY"));
            mZoomScale = Integer.parseInt(element.getAttribute("ZoomScale"));

            mGraph.getLines().clear();
            mGraph.getNodes().clear();

            NodeList metroGraphNodeList = document.getChildNodes();
            for (int i = 0; i < metroGraphNodeList.getLength(); ++i) {

                Node metroGraphNode = metroGraphNodeList.item(i);
                NodeList linesNodes = metroGraphNode.getChildNodes();

                for (int j = 0; j < linesNodes.getLength(); j++) {
                    Node node = linesNodes.item(j);
                    if (node.getNodeName() == "Lines") {
                        Node lines = node;
                        NodeList lineList = lines.getChildNodes();

                        for (int k = 0; k < lineList.getLength(); k++) {
                            node = lineList.item(k);

                            if (node.getNodeName() == "Line") {
                                NamedNodeMap namedNodeMap = node.getAttributes();
                                System.out.println(namedNodeMap.getNamedItem("Name"));
                                // 线路
                                mGraph.getLines().put(namedNodeMap.getNamedItem("Name").getNodeValue(),
                                        new MetroLine(namedNodeMap.getNamedItem("Name").getNodeValue(), new Color(Integer.parseInt(namedNodeMap.getNamedItem("Color").getNodeValue()))));

                            }
                        }

                    } else if (node.getNodeName() == "Nodes") {
                        Node nodes = node;
                        NodeList nodeList = nodes.getChildNodes();

                        for (int k = 0; k < nodeList.getLength(); k++) {
                            node = nodeList.item(k);

                            if (node.getNodeName() == "Node") {
                                NamedNodeMap namedNodeMap = node.getAttributes();
                                System.out.println(namedNodeMap.getNamedItem("Name"));
                                // 站点
                                mGraph.getNodes().put(namedNodeMap.getNamedItem("Name").getNodeValue(),
                                        new MetroNode(namedNodeMap.getNamedItem("Name").getNodeValue(),
                                                Integer.parseInt(namedNodeMap.getNamedItem("X").getNodeValue()),
                                                Integer.parseInt(namedNodeMap.getNamedItem("Y").getNodeValue())));

                            }
                        }
                    }
                }


                // 路径
                for (int j = 0; j < linesNodes.getLength(); j++) {

                    NodeList nodes = linesNodes.item(j).getChildNodes();
                    for (int k = 0; k < nodes.getLength(); k++) {
                        Node node = nodes.item(k);
                        NodeList links = nodes.item(k).getChildNodes();

                        if (nodes.item(k).getNodeName() == "Node") {

                            NamedNodeMap namedNodeMap = node.getAttributes();
                            MetroNode from = mGraph.getNodes().get(namedNodeMap.getNamedItem("Name").getNodeValue());

                            for (int l = 0; l < links.getLength(); l++) {
                                node = links.item(l);
                                if (node.getNodeName() == "Link") {
                                    node = links.item(l);
                                    if (node.getNodeName() == "Link") {
                                        namedNodeMap = node.getAttributes();
                                        MetroNode to = mGraph.getNodes().get(namedNodeMap.getNamedItem("To").getNodeValue());
                                        MetroLine line = mGraph.getLines().get(namedNodeMap.getNamedItem("Line").getNodeValue());
                                        from.getLinks().add(new MetroLink(from, to, line,
                                                Float.parseFloat(namedNodeMap.getNamedItem("Weight").getNodeValue()),
                                                Integer.parseInt(namedNodeMap.getNamedItem("Flag").getNodeValue())));
                                    }

                                }

                            }
                        }
                    }
                }
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ArgumentNullException e) {
            e.printStackTrace();
        }

    }

    /**
     * 检测是否存在站点
     *
     * @param point
     */
    private void CheckNode(Point point) {
        int flag = 0;
        for (MetroNode node :
                mGraph.getNodes().values()) {
            if (IsNear(node.getX(), node.getY(), point)) {
                if (mStartNode == null)
                {
                    mStartNode = node;
                }
                else {
                    mEndNode = node;
                    FindPath();
                }

                flag = 1;
                break;
            }
        }
        if (flag == 0 && mStartNode != null) {
            mStartNode = mEndNode = null;
            mPathNodes = null;
        }
    }

    /**
     * 寻路
     */
    private void FindPath() {
        if(mStrategy == Strategy.MIN_TRANS)
            mPathNodes = mGraph.FindMinTransPath(mStartNode,mEndNode);
        else
            mPathNodes = mGraph.FindPath(mStartNode,mEndNode);
    }

    /**
     * 判断两点是否临近
     *
     * @param x
     * @param y
     * @param point
     * @return
     */
    private boolean IsNear(int x, int y, Point point) {

        if (Math.abs(x - point.x) < 30 && Math.abs(y - point.y) < 30)
            return true;
        else
            return false;
    }

    /**
     * 获得所在相同路线
     * @param node1
     * @param node2
     * @return
     */
    private MetroLine getSameLine(MetroNode node1,MetroNode node2) {

        for(MetroLine line1 : node1.getLines()) {
            for(MetroLine line2 : node2.getLines()) {
                if(line1 == line2)
                    return line1;
            }
        }
        return null;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

       if(mouseEvent.getButton()!= MouseEvent.BUTTON3)
       {
           CheckNode(new Point((int) ((mouseEvent.getPoint().getX() - mScrollX) / mZoomScale), (int) ((mouseEvent.getPoint().getY() - mScrollY) / mZoomScale)));
           updateUI();
       }

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        mMouseLastPoint = mouseEvent.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {


    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent mouseWheelEvent) {

        if (mouseWheelEvent.getWheelRotation() < 0 && mZoomScale < 3) {
            mZoomScale += 0.1;
            mScrollX -= 0.1 * mouseWheelEvent.getX();
            mScrollY -= 0.1 * mouseWheelEvent.getY();
        } else if (mZoomScale > 0.2) {
            mZoomScale -= 0.1;
            mScrollX += 0.1 * mouseWheelEvent.getX();
            mScrollY += 0.1 * mouseWheelEvent.getY();
        }
        updateUI();

    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {


        if (mouseEvent.getX() - mMouseLastPoint.x > 0 && mScrollX < 1800 * mZoomScale)
            mScrollX += mouseEvent.getX() - mMouseLastPoint.x;
        if (mouseEvent.getY() - mMouseLastPoint.y > 0 && mScrollY < 1000 * mZoomScale)
            mScrollY += mouseEvent.getY() - mMouseLastPoint.y;
        if (mouseEvent.getX() - mMouseLastPoint.x < 0 && mScrollX > -1800 * mZoomScale)
            mScrollX += mouseEvent.getX() - mMouseLastPoint.x;
        if (mouseEvent.getY() - mMouseLastPoint.y < 0 && mScrollY > -1000 * mZoomScale)
            mScrollY += mouseEvent.getY() - mMouseLastPoint.y;
        mMouseLastPoint = mouseEvent.getPoint();
        updateUI();
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}


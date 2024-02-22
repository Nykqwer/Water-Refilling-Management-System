/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fhs;

import static fhs.waterrefilling1.tender_amount;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
/**
 *
 * @author Nyko
 */
public class waterrefilling1 extends javax.swing.JFrame {
  private Connection cn;
    private Statement st;
    private Connection conn = null;
    private PreparedStatement pst = null;
    ResultSet rs = null;
    /**
     * Creates new form waterrefilling1
     */
    public waterrefilling1() {
        initComponents();
        times();
        dt();
        showPieChart();
        showBarChart();
        showLineChart();
    }
public void dt(){
 Date d = new Date();
 
 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
 
 String df = sdf.format(d);
 c_date.setText(df);
 
}
     Timer t;
    SimpleDateFormat stz;
    
public void times(){

   
    
    t = new Timer(0, new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e){
    
    Date dt = new Date();
    stz = new SimpleDateFormat("hh:mm:ss a");
    
    String tt = stz.format(dt);
    tc.setText(tt);
    }
    
    
    });
    t.start();
}

public void showPieChart(){
        
        //create dataset
      DefaultPieDataset barDataset = new DefaultPieDataset( );
      barDataset.setValue( "Gallon-slim" , new Double( 35 ) );  
      barDataset.setValue( "Gallon-Round" , new Double( 65 ) );    
        
      
      //create chart
       JFreeChart piechart = ChartFactory.createPieChart("Gallons Consumption",barDataset, false,true,false);//explain
      
        PiePlot piePlot =(PiePlot) piechart.getPlot();
      
       //changing pie chart blocks colors
       piePlot.setSectionPaint("IPhone 5s", new Color(255,255,102));
        piePlot.setSectionPaint("SamSung Grand", new Color(255,102,153));
        piePlot.setSectionPaint("MotoG", new Color(255,102,153));
        piePlot.setSectionPaint("Nokia Lumia", new Color(255,102,153));
      
       
        piePlot.setBackgroundPaint(Color.white);
        
        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);
        panelBarChart.removeAll();
        panelBarChart.add(barChartPanel, BorderLayout.CENTER);
        panelBarChart.validate();
    }
public void showBarChart(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(200, "Amount", "january");
        dataset.setValue(150, "Amount", "february");
        dataset.setValue(18, "Amount", "march");
        dataset.setValue(100, "Amount", "april");
        dataset.setValue(80, "Amount", "may");
        dataset.setValue(250, "Amount", "june");
        
        JFreeChart chart = ChartFactory.createBarChart("Sales","monthly","amount", 
                dataset, PlotOrientation.VERTICAL, false,true,false);
        
        CategoryPlot categoryPlot = chart.getCategoryPlot();
        //categoryPlot.setRangeGridlinePaint(Color.BLUE);
        categoryPlot.setBackgroundPaint(Color.white);
        BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
        Color clr3 = new Color(204,0,51);
        renderer.setSeriesPaint(0, clr3);
        
        ChartPanel barpChartPanel = new ChartPanel(chart);
        panelLineChart1.removeAll();
        panelLineChart1.add(barpChartPanel, BorderLayout.CENTER);
        panelLineChart1.validate();
        
        
    }

    
    public void showLineChart(){
        //create dataset for the graph
         DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(200, "Amount", "january");
        dataset.setValue(150, "Amount", "february");
        dataset.setValue(18, "Amount", "march");
        dataset.setValue(100, "Amount", "april");
        dataset.setValue(80, "Amount", "may");
        dataset.setValue(250, "Amount", "june");
        
        //create chart
        JFreeChart linechart = ChartFactory.createLineChart("contribution","monthly","amount", 
                dataset, PlotOrientation.VERTICAL, false,true,false);
        
        //create plot object
         CategoryPlot lineCategoryPlot = linechart.getCategoryPlot();
       // lineCategoryPlot.setRangeGridlinePaint(Color.BLUE);
        lineCategoryPlot.setBackgroundPaint(Color.white);
        
        //create render object to change the moficy the line properties like color
        LineAndShapeRenderer lineRenderer = (LineAndShapeRenderer) lineCategoryPlot.getRenderer();
        Color lineChartColor = new Color(204,0,51);
        lineRenderer.setSeriesPaint(0, lineChartColor);
        
         //create chartPanel to display chart(graph)
        ChartPanel lineChartPanel = new ChartPanel(linechart);
        panelLineChart.removeAll();
        panelLineChart.add(lineChartPanel, BorderLayout.CENTER);
        panelLineChart.validate();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        dashboard1 = new javax.swing.JLabel();
        POS = new javax.swing.JLabel();
        Inventory = new javax.swing.JLabel();
        customer1 = new javax.swing.JLabel();
        Delivery = new javax.swing.JLabel();
        Delivery1 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator20 = new javax.swing.JSeparator();
        jSeparator21 = new javax.swing.JSeparator();
        tc = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        c_date = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        parentpanel = new javax.swing.JPanel();
        dashboard = new javax.swing.JPanel();
        panelLineChart = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        sales_dashboard = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        credit_dashboard = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        stocks_dashboard = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        panelLineChart1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        delivered_dashboard = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        transaction = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        asddd = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        asd = new javax.swing.JLabel();
        date_chooser = new com.toedter.calendar.JDateChooser();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        customer_table = new javax.swing.JTable();
        search = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pos_table = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        paid_table = new javax.swing.JTable();
        jSeparator16 = new javax.swing.JSeparator();
        jLabel27 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        Receipt = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        lblquantity = new javax.swing.JLabel();
        lblprice = new javax.swing.JLabel();
        cart = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        balance1 = new javax.swing.JTextField();
        change = new javax.swing.JTextField();
        tender_amount = new javax.swing.JTextField();
        lblprice1 = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        paid01 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        reciept_table = new javax.swing.JTable();
        jLabel42 = new javax.swing.JLabel();
        total_amountrc = new javax.swing.JLabel();
        jSeparator17 = new javax.swing.JSeparator();
        jSeparator15 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        quantity1 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        quantity = new javax.swing.JTextField();
        type = new javax.swing.JComboBox();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        asdd = new javax.swing.JLabel();
        customer_name01 = new javax.swing.JLabel();
        customer_addr = new javax.swing.JLabel();
        customer_no = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jSeparator18 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        id_numberlabel1 = new javax.swing.JLabel();
        delivery = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        date_chooser1 = new com.toedter.calendar.JDateChooser();
        jScrollPane4 = new javax.swing.JScrollPane();
        textarea = new javax.swing.JTextArea();
        save = new javax.swing.JButton();
        save1 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        sched_table = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        delivery_table = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        searchdelivery = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        inventory = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        item_name = new javax.swing.JTextField();
        fhs_gallon = new javax.swing.JTextField();
        quantity3 = new javax.swing.JTextField();
        return_gallon = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel45 = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        jLabel46 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jScrollPane7 = new javax.swing.JScrollPane();
        inventory_table = new javax.swing.JTable();
        jLabel60 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        fhs_gallons1 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        fhs_gallons2 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        panelBarChart = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        worth = new javax.swing.JTextField();
        customer = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        customer_table1 = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        search1 = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        delete = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jSeparator14 = new javax.swing.JSeparator();
        customer_name1 = new javax.swing.JLabel();
        customer_id1 = new javax.swing.JLabel();
        customer_address1 = new javax.swing.JLabel();
        customer_contact1 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        id_number = new javax.swing.JTextField();
        c_name1 = new javax.swing.JTextField();
        contact1 = new javax.swing.JTextField();
        address1 = new javax.swing.JTextField();
        credit = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        credit_table = new javax.swing.JTable();
        dashboard2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        jSeparator19 = new javax.swing.JSeparator();
        jLabel52 = new javax.swing.JLabel();
        searchcredit = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 600, 220, 10));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/watershit.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 220, 100));

        dashboard1.setFont(new java.awt.Font("Arial Black", 0, 25)); // NOI18N
        dashboard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/speedometer (1).png"))); // NOI18N
        dashboard1.setText("Dashboard");
        dashboard1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashboard1MouseClicked(evt);
            }
        });
        getContentPane().add(dashboard1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 210, 40));

        POS.setFont(new java.awt.Font("Arial Black", 0, 26)); // NOI18N
        POS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cash-flow (1).png"))); // NOI18N
        POS.setText("Sales");
        POS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                POSMouseClicked(evt);
            }
        });
        getContentPane().add(POS, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 170, 40));

        Inventory.setFont(new java.awt.Font("Arial Black", 0, 25)); // NOI18N
        Inventory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/inventory (2) (1).png"))); // NOI18N
        Inventory.setText("Inventory");
        Inventory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InventoryMouseClicked(evt);
            }
        });
        getContentPane().add(Inventory, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 380, 210, 40));

        customer1.setFont(new java.awt.Font("Arial Black", 0, 25)); // NOI18N
        customer1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/customer-review (1).png"))); // NOI18N
        customer1.setText("Customer");
        customer1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customer1MouseClicked(evt);
            }
        });
        getContentPane().add(customer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, -1, 40));

        Delivery.setFont(new java.awt.Font("Arial Black", 0, 25)); // NOI18N
        Delivery.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delivery (1).png"))); // NOI18N
        Delivery.setText("Delivery");
        Delivery.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeliveryMouseClicked(evt);
            }
        });
        getContentPane().add(Delivery, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 190, 40));

        Delivery1.setFont(new java.awt.Font("Arial Black", 0, 23)); // NOI18N
        Delivery1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/business-credit-score (1).png"))); // NOI18N
        Delivery1.setText("Uncollectible");
        Delivery1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Delivery1MouseClicked(evt);
            }
        });
        getContentPane().add(Delivery1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 210, 40));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 220, 20));
        getContentPane().add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 220, 10));
        getContentPane().add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 220, 10));
        getContentPane().add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 220, 10));
        getContentPane().add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 220, 10));

        jSeparator20.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jSeparator20, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 60, 120, 20));

        jSeparator21.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jSeparator21, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 60, 120, 30));

        tc.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        getContentPane().add(tc, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 40, 120, 30));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel11.setText("TIME:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 40, 50, 30));

        c_date.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        getContentPane().add(c_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 40, 120, 30));

        jLabel59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bottle (1).png"))); // NOI18N
        getContentPane().add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 630, 70, 70));

        jLabel58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/gallon (1).png"))); // NOI18N
        getContentPane().add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 630, -1, -1));

        jLabel29.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel29.setText("DATE:");
        getContentPane().add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 40, 70, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cool.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 700));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Cool Blues.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-230, 0, 1580, 80));

        parentpanel.setLayout(new java.awt.CardLayout());

        dashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashboardMouseClicked(evt);
            }
        });
        dashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelLineChart.setLayout(new java.awt.BorderLayout());
        dashboard.add(panelLineChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, 370, 240));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 0, 0, 0, new java.awt.Color(51, 51, 255)));

        sales_dashboard.setFont(new java.awt.Font("Arial", 1, 38)); // NOI18N
        sales_dashboard.setText("20");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(sales_dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sales_dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        dashboard.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 180, 110));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 0, 0, 0, new java.awt.Color(51, 51, 255)));

        credit_dashboard.setFont(new java.awt.Font("Arial", 1, 38)); // NOI18N
        credit_dashboard.setText("20");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(credit_dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(credit_dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        dashboard.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 180, 200, 110));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 0, 0, 0, new java.awt.Color(255, 0, 0)));

        stocks_dashboard.setFont(new java.awt.Font("Arial", 1, 38)); // NOI18N
        stocks_dashboard.setText("20");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(stocks_dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(stocks_dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        dashboard.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 190, 110));

        jLabel10.setFont(new java.awt.Font("Arial Black", 1, 34)); // NOI18N
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Customers.png"))); // NOI18N
        jLabel10.setText("Dashboard");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        dashboard.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 330, 60));

        panelLineChart1.setLayout(new java.awt.BorderLayout());
        dashboard.add(panelLineChart1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 330, 370, 240));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 0, 0, 0, new java.awt.Color(255, 0, 0)));

        delivered_dashboard.setFont(new java.awt.Font("Arial", 1, 38)); // NOI18N
        delivered_dashboard.setText("20");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(delivered_dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(delivered_dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        dashboard.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 180, 200, 110));

        jLabel57.setFont(new java.awt.Font("Arial", 1, 19)); // NOI18N
        jLabel57.setText("DELIVERED");
        dashboard.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 150, 140, 30));

        jLabel54.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel54.setText("TOTAL UNCOLLECTED");
        dashboard.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 150, 230, 30));

        jLabel55.setFont(new java.awt.Font("Arial", 1, 19)); // NOI18N
        jLabel55.setText("TOTAL SALES");
        dashboard.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 140, 30));

        jLabel56.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel56.setText("AVAILABLE GALLONS");
        dashboard.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 210, 30));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Background.png"))); // NOI18N
        dashboard.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -10, 1430, 710));

        parentpanel.add(dashboard, "card3");

        transaction.setMaximumSize(new java.awt.Dimension(1190, 720));
        transaction.setMinimumSize(new java.awt.Dimension(1190, 720));
        transaction.setPreferredSize(new java.awt.Dimension(1190, 720));
        transaction.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/identification (1).png"))); // NOI18N
        jLabel24.setText("Customer Details");
        transaction.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, -1, -1));

        asddd.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        asddd.setText("Contact No.:");
        transaction.add(asddd, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, -1, 20));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel14.setText("Date:");
        transaction.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 460, -1, -1));

        asd.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        asd.setText("Customer Name:");
        transaction.add(asd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, 30));
        transaction.add(date_chooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 450, 180, 30));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        customer_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID number", "Customer Name", "Address", "Contact"
            }
        ));
        customer_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customer_tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(customer_table);

        jPanel8.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 46, 1030, 170));

        search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchMouseClicked(evt);
            }
        });
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });
        jPanel8.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 203, 29));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        jPanel8.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 30, 30));

        jLabel25.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel25.setText("Search:");
        jPanel8.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, -1, 20));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Cool Blues.png"))); // NOI18N
        jPanel8.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1060, 260));

        jTabbedPane1.addTab("Customer", jPanel8);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pos_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID number", "Customer Name", "Address", "Type", "Contact", "No of Gallon", "Price", "Balance", "Date"
            }
        ));
        pos_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pos_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(pos_table);

        jPanel11.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 24, 1030, 200));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Cool Blues.png"))); // NOI18N
        jPanel11.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 250));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("add to cart", jPanel9);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        paid_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID number", "Customer Name", "Address", "Type", "Contact", "No of Gallon", "Price", "balance", "date"
            }
        ));
        paid_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paid_tableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(paid_table);

        jPanel14.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 1030, 190));

        jSeparator16.setForeground(new java.awt.Color(255, 255, 255));
        jPanel14.add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, 230, 10));

        jLabel27.setFont(new java.awt.Font("Arial", 1, 25)); // NOI18N
        jLabel27.setText("Transaction Paid");
        jPanel14.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 220, 30));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Cool Blues.png"))); // NOI18N
        jPanel14.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 250));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Paid", jPanel13);

        transaction.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 1060, 270));

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Receipt.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Receipt.setText("Reciept");
        jPanel6.add(Receipt, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel19.setText("Order Item Summary");
        jPanel6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel26.setText("Total Amount");
        jPanel15.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        lblquantity.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblquantityMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblquantityMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblquantityMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblquantityMousePressed(evt);
            }
        });
        jPanel15.add(lblquantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 40, 90, 24));

        lblprice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblpriceMousePressed(evt);
            }
        });
        jPanel15.add(lblprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 100, 30));

        cart.setText("add to cart");
        cart.setEnabled(false);
        cart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartMouseClicked(evt);
            }
        });
        cart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cartActionPerformed(evt);
            }
        });
        jPanel15.add(cart, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 213, 90, 30));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel28.setText("QTY");
        jPanel15.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel30.setText("Tendered Amount");
        jPanel15.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, -1));

        balance1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                balance1ActionPerformed(evt);
            }
        });
        jPanel15.add(balance1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 120, 30));

        change.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeActionPerformed(evt);
            }
        });
        jPanel15.add(change, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 120, 30));

        tender_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tender_amountActionPerformed(evt);
            }
        });
        tender_amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tender_amountKeyReleased(evt);
            }
        });
        jPanel15.add(tender_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 120, 30));

        lblprice1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblprice1ActionPerformed(evt);
            }
        });
        jPanel15.add(lblprice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 110, 30));

        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel63.setText("Balance");
        jPanel15.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, -1, -1));

        jLabel33.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        jLabel33.setText("Contact Number:");
        jPanel15.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 140, -1));

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel41.setText("Total Change");
        jPanel15.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, -1, -1));

        paid01.setText("Pay");
        paid01.setEnabled(false);
        paid01.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paid01MouseClicked(evt);
            }
        });
        paid01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paid01ActionPerformed(evt);
            }
        });
        jPanel15.add(paid01, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 76, -1));

        jPanel6.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 350, 250));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        reciept_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Particular", "Quantity", "Price"
            }
        ));
        jScrollPane9.setViewportView(reciept_table);

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel42.setText("Total Amount:");

        total_amountrc.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel42)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(total_amountrc, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
            .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel42, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(total_amountrc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel6.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, 260, 250));

        jSeparator17.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 100, 10));

        jSeparator15.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 200, 10));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Cool Blues.png"))); // NOI18N
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 310));

        transaction.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 320, -1, 310));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        quantity1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                quantity1MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                quantity1MouseReleased(evt);
            }
        });
        quantity1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantity1ActionPerformed(evt);
            }
        });
        quantity1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                quantity1PropertyChange(evt);
            }
        });
        quantity1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                quantity1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                quantity1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                quantity1KeyTyped(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel17.setText("no of Gallon - Round");

        jLabel16.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel16.setText("no of Gallon - Slim");

        jLabel15.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel15.setText("Type");

        quantity.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                quantityMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                quantityMouseReleased(evt);
            }
        });
        quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityActionPerformed(evt);
            }
        });
        quantity.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                quantityPropertyChange(evt);
            }
        });
        quantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                quantityKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                quantityKeyTyped(evt);
            }
        });

        type.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Type", "Walk-in", "Delivery" }));
        type.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                typeMouseClicked(evt);
            }
        });
        type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel15)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(quantity1)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel16)
                    .addComponent(jLabel15))
                .addGap(48, 48, 48)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantity1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );

        transaction.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 460, 140));
        transaction.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, 220, 20));
        transaction.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 220, 20));
        transaction.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 390, 220, 20));

        jLabel20.setBackground(new java.awt.Color(0, 0, 0));
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh-removebg-preview (1).png"))); // NOI18N
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });
        transaction.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 450, 40, 30));

        asdd.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        asdd.setText("Address:");
        transaction.add(asdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, -1, 20));

        customer_name01.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        transaction.add(customer_name01, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, 220, 30));

        customer_addr.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        transaction.add(customer_addr, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, 220, 30));

        customer_no.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        transaction.add(customer_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 410, 220, 30));

        jButton3.setText("     Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        transaction.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 450, 80, 30));
        transaction.add(jSeparator18, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 250, 10));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Background.png"))); // NOI18N
        jLabel7.setText(" ");
        jLabel7.setMaximumSize(new java.awt.Dimension(1420, 681));
        jLabel7.setMinimumSize(new java.awt.Dimension(1420, 681));
        jLabel7.setPreferredSize(new java.awt.Dimension(1420, 681));
        transaction.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1140, 670));
        transaction.add(id_numberlabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 80, 20));

        parentpanel.add(transaction, "card4");

        delivery.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setFont(new java.awt.Font("Arial Black", 0, 23)); // NOI18N
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/planner21.png"))); // NOI18N
        jLabel31.setText(" Task Calendar");
        delivery.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, -1, 40));
        delivery.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 250, 10));
        delivery.add(date_chooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 140, 30));

        textarea.setColumns(20);
        textarea.setRows(5);
        textarea.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                textareaPropertyChange(evt);
            }
        });
        jScrollPane4.setViewportView(textarea);

        delivery.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 250, 220));

        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        delivery.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 80, -1));

        save1.setText("delete");
        save1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save1ActionPerformed(evt);
            }
        });
        delivery.add(save1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 80, -1));

        sched_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Schedule of Deliveries"
            }
        ));
        sched_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sched_tableMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(sched_table);

        delivery.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 320, 80));

        delivery_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID number", "Customer Name", "Status", "No. of Gallon", "Price", "Status", "Date"
            }
        ));
        jScrollPane6.setViewportView(delivery_table);

        delivery.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 200, 720, 280));

        jLabel9.setFont(new java.awt.Font("Arial Black", 0, 28)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delivery-truck (1)_1.png"))); // NOI18N
        jLabel9.setText("Delivered Gallons");
        delivery.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, 390, 40));
        delivery.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 100, 370, 20));

        jLabel65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/find-my-friend (1)_1.png"))); // NOI18N
        delivery.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 160, 40, 30));

        jLabel66.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel66.setText("Search:");
        delivery.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 170, -1, -1));

        searchdelivery.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchdeliveryKeyReleased(evt);
            }
        });
        delivery.add(searchdelivery, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 160, 170, 30));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Background.png"))); // NOI18N
        delivery.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 700));

        parentpanel.add(delivery, "card5");

        inventory.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(item_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 150, 30));

        fhs_gallon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fhs_gallonKeyReleased(evt);
            }
        });
        jPanel2.add(fhs_gallon, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 150, 30));

        quantity3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                quantity3KeyReleased(evt);
            }
        });
        jPanel2.add(quantity3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 150, 30));

        return_gallon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                return_gallonKeyReleased(evt);
            }
        });
        jPanel2.add(return_gallon, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 150, 30));

        jButton4.setText("Clear");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, -1, -1));

        jLabel35.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        jLabel35.setText("Add Gallons");
        jPanel2.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        jLabel36.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel36.setText("FHS Gal:");
        jPanel2.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, -1));

        jLabel43.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel43.setText("Quantity:");
        jPanel2.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        jLabel44.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel44.setText("Return Gal:");
        jPanel2.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        jButton5.setText("Reset Inventory");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, -1, -1));

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, -1, -1));

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, -1, -1));

        jLabel45.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel45.setText("Item Name:");
        jPanel2.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));
        jPanel2.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 180, 10));

        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Cool Blues.png"))); // NOI18N
        jPanel2.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 440));

        inventory.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 330, 440));
        inventory.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 380, 20));

        inventory_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Item Name", "Quantity", "Worth", "Return Gallons", "FHS Gallons", "Date"
            }
        ));
        inventory_table.setMaximumSize(new java.awt.Dimension(1207, 700));
        inventory_table.setMinimumSize(new java.awt.Dimension(1207, 700));
        inventory_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inventory_tableMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(inventory_table);

        inventory.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 400, 710, 200));

        jLabel60.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel60.setText("GALLON-ROUND");
        inventory.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 130, 140, 30));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 0, 0, 0, new java.awt.Color(255, 0, 0)));

        fhs_gallons1.setFont(new java.awt.Font("Arial", 1, 32)); // NOI18N
        fhs_gallons1.setText("20");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(fhs_gallons1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fhs_gallons1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        inventory.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 160, 150, 100));

        jLabel61.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel61.setText(" GALLON-SLIM");
        inventory.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 130, 130, 30));

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 0, 0, 0, new java.awt.Color(255, 0, 0)));

        fhs_gallons2.setFont(new java.awt.Font("Arial", 1, 32)); // NOI18N
        fhs_gallons2.setText("20");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(fhs_gallons2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fhs_gallons2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        inventory.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 160, 150, 100));

        jLabel62.setFont(new java.awt.Font("Arial Black", 0, 32)); // NOI18N
        jLabel62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/inventory (1) (1).png"))); // NOI18N
        jLabel62.setText("Inventory");
        inventory.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 260, -1));

        panelBarChart.setLayout(new java.awt.BorderLayout());
        inventory.add(panelBarChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, 260, 210));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Background.png"))); // NOI18N
        inventory.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -120, 1210, 930));

        worth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                worthActionPerformed(evt);
            }
        });
        worth.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                worthPropertyChange(evt);
            }
        });
        worth.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                worthKeyReleased(evt);
            }
        });
        inventory.add(worth, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 598, 117, 30));

        parentpanel.add(inventory, "card6");

        customer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel21MouseClicked(evt);
            }
        });
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel32.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel32.setText("New Customer");
        jLabel32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel32MouseClicked(evt);
            }
        });
        jPanel21.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 110, 30));

        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Cool Blues.png"))); // NOI18N
        jPanel21.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 50));

        customer.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 440, 150, 50));

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel20MouseClicked(evt);
            }
        });
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel38.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel38.setText("Update Customer");
        jLabel38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel38MouseClicked(evt);
            }
        });
        jPanel20.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 30));

        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Cool Blues.png"))); // NOI18N
        jPanel20.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 50));

        customer.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 440, 150, 50));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        customer_table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID number", "Customer Name", "Address", "Contact"
            }
        ));
        customer_table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customer_table1MouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(customer_table1);

        jPanel18.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 660, 200));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/find-my-friend (1)_1.png"))); // NOI18N
        jPanel18.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 40, 30));

        jLabel39.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel39.setText("Search:");
        jPanel18.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, -1));

        search1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                search1MouseClicked(evt);
            }
        });
        search1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search1ActionPerformed(evt);
            }
        });
        search1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search1KeyReleased(evt);
            }
        });
        jPanel18.add(search1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 180, 30));

        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Cool Blues.png"))); // NOI18N
        jPanel18.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 290));

        customer.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 720, 290));

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel19MouseClicked(evt);
            }
        });
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        delete.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        delete.setText("Remove Customer");
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteMouseClicked(evt);
            }
        });
        jPanel19.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 30));

        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Cool Blues.png"))); // NOI18N
        jPanel19.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 50));

        customer.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 440, 150, 50));
        customer.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 102, 340, 20));

        customer_name1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                customer_name1PropertyChange(evt);
            }
        });
        customer.add(customer_name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 110, 20));

        customer_id1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                customer_id1PropertyChange(evt);
            }
        });
        customer.add(customer_id1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 110, 20));

        customer_address1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                customer_address1PropertyChange(evt);
            }
        });
        customer.add(customer_address1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 110, 20));

        customer_contact1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                customer_contact1PropertyChange(evt);
            }
        });
        customer.add(customer_contact1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 110, 20));

        jLabel37.setFont(new java.awt.Font("Arial Black", 1, 29)); // NOI18N
        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/target (1).png"))); // NOI18N
        jLabel37.setText(" Customers");
        jLabel37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel37MouseClicked(evt);
            }
        });
        customer.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, 270, 100));

        jLabel40.setBackground(new java.awt.Color(255, 255, 255));
        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Background.png"))); // NOI18N
        customer.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1200, 590));

        id_number.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_numberActionPerformed(evt);
            }
        });
        id_number.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                id_numberPropertyChange(evt);
            }
        });
        id_number.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                id_numberKeyTyped(evt);
            }
        });
        customer.add(id_number, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 0, -1));

        c_name1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_name1ActionPerformed(evt);
            }
        });
        c_name1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                c_name1PropertyChange(evt);
            }
        });
        customer.add(c_name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));

        contact1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                contact1PropertyChange(evt);
            }
        });
        customer.add(contact1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, 10));

        address1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                address1PropertyChange(evt);
            }
        });
        customer.add(address1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, -1, 10));

        parentpanel.add(customer, "card7");

        credit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        credit_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Customer Name", "Address", "Contact", "No of Gallon", "Balance", "Date"
            }
        ));
        credit_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                credit_tableMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(credit_table);

        credit.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 790, 240));

        dashboard2.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        dashboard2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/credit-removebg-preview (1).png"))); // NOI18N
        dashboard2.setText(" Uncollectible Log");
        credit.add(dashboard2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, 310, 40));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel53.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel53.setText("Uncollected");
        jPanel3.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 100, 20));

        jLabel49.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel49.setText("Total:");
        jPanel3.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, 30));

        total.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jPanel3.add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 100, 30));
        jPanel3.add(jSeparator19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 140, 20));

        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Cool Blues.png"))); // NOI18N
        jPanel3.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 120));

        credit.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 420, 180, 120));

        searchcredit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchcreditKeyReleased(evt);
            }
        });
        credit.add(searchcredit, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 170, 30));

        jLabel64.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel64.setText("Search:");
        credit.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, -1, -1));

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/find-my-friend (1)_1.png"))); // NOI18N
        credit.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 130, 40, 30));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Background.png"))); // NOI18N
        credit.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -40, 1300, 760));

        parentpanel.add(credit, "card8");

        getContentPane().add(parentpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 1130, 620));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void dashboard1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboard1MouseClicked

        parentpanel.removeAll();
        parentpanel.add(dashboard);
        parentpanel.repaint();
        parentpanel.revalidate();
    }//GEN-LAST:event_dashboard1MouseClicked

    private void POSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_POSMouseClicked
        parentpanel.removeAll();
        parentpanel.add(transaction);
        parentpanel.repaint();
        parentpanel.revalidate();
    }//GEN-LAST:event_POSMouseClicked

    private void InventoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InventoryMouseClicked
        parentpanel.removeAll();
        parentpanel.add(inventory);
        parentpanel.repaint();
        parentpanel.revalidate();
    }//GEN-LAST:event_InventoryMouseClicked

    private void customer1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customer1MouseClicked
        parentpanel.removeAll();
        parentpanel.add(customer);
        parentpanel.repaint();
        parentpanel.revalidate();
    }//GEN-LAST:event_customer1MouseClicked

    private void DeliveryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeliveryMouseClicked
        parentpanel.removeAll();
        parentpanel.add(delivery);
        parentpanel.repaint();
        parentpanel.revalidate();
    }//GEN-LAST:event_DeliveryMouseClicked

    private void Delivery1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Delivery1MouseClicked
        parentpanel.removeAll();
        parentpanel.add(credit);
        parentpanel.repaint();
        parentpanel.revalidate();
    }//GEN-LAST:event_Delivery1MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseClicked

    private void dashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_dashboardMouseClicked

    private void customer_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customer_tableMouseClicked
        DefaultTableModel model = (DefaultTableModel) customer_table.getModel();
        int selectedRowIndex = customer_table.getSelectedRow();
        id_numberlabel1.setText(model.getValueAt(selectedRowIndex,0).toString());
        customer_name01.setText(model.getValueAt(selectedRowIndex,1).toString());
        customer_addr.setText(model.getValueAt(selectedRowIndex,2).toString());
        customer_no.setText(model.getValueAt(selectedRowIndex,3).toString());
    }//GEN-LAST:event_customer_tableMouseClicked

    private void searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseClicked

    }//GEN-LAST:event_searchMouseClicked

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed

    }//GEN-LAST:event_searchActionPerformed

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        searchPOS1();
    }//GEN-LAST:event_searchKeyReleased

    private void pos_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pos_tableMouseClicked
       
     
 
                  DefaultTableModel model = (DefaultTableModel) pos_table.getModel();
        int selectedRowIndex = pos_table.getSelectedRow();
         id_numberlabel1.setText(model.getValueAt(selectedRowIndex, 0).toString());
         customer_name01.setText(model.getValueAt(selectedRowIndex, 1).toString());
        customer_addr.setText(model.getValueAt(selectedRowIndex, 2).toString());
        String subject = model.getValueAt(selectedRowIndex, 3).toString();
        switch (subject) {
            case "Type":
            type.setSelectedIndex(0);
            case "Walk-in":
            type.setSelectedIndex(1);
            break;
            case "Delivery":
            type.setSelectedIndex(2);
            break;
        }
        customer_no.setText(model.getValueAt(selectedRowIndex, 4).toString());
        lblquantity.setText(model.getValueAt(selectedRowIndex, 5).toString());
        lblprice1.setText(model.getValueAt(selectedRowIndex, 6).toString());
        balance1.setText(model.getValueAt(selectedRowIndex, 7).toString());
        try {
            int row = pos_table.getSelectedRow();
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(row, 8).toString());
            date_chooser.setDate(date);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
         paid01.setEnabled(true);
         cart.setEnabled(false);
          
       
    }//GEN-LAST:event_pos_tableMouseClicked

    private void paid_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paid_tableMouseClicked

        DefaultTableModel model = (DefaultTableModel) paid_table.getModel();
        int selectedRowIndex = paid_table.getSelectedRow();
        id_numberlabel1.setText(model.getValueAt(selectedRowIndex, 0).toString());
        customer_name01.setText(model.getValueAt(selectedRowIndex, 1).toString());
        customer_addr.setText(model.getValueAt(selectedRowIndex, 2).toString());
          String subject = model.getValueAt(selectedRowIndex, 3).toString();
        switch (subject) {
            case "Walk-in":
            type.setSelectedIndex(0);
            break;
            case "Delivery":
            type.setSelectedIndex(1);
            break;
        }
        customer_no.setText(model.getValueAt(selectedRowIndex, 4).toString());
        lblquantity.setText(model.getValueAt(selectedRowIndex, 5).toString());
    }//GEN-LAST:event_paid_tableMouseClicked

    private void lblquantityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblquantityMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblquantityMouseClicked

    private void lblquantityMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblquantityMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lblquantityMouseEntered

    private void lblquantityMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblquantityMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_lblquantityMouseExited

    private void lblquantityMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblquantityMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblquantityMousePressed

    private void lblpriceMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblpriceMousePressed

    }//GEN-LAST:event_lblpriceMousePressed

    private void cartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartMouseClicked

    }//GEN-LAST:event_cartMouseClicked

    private void cartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cartActionPerformed
          
        if(tender_amount.getText().isEmpty()){
             JOptionPane.showMessageDialog(null, "Error tendered amount should not be empty");
        }
        else{
            POS();
        update_inventoryPOS();
        CreditPOS();
          gallonsPOS();
          deliveryPOS_PENDING();
           retreive_POS();
         retrieve_customerDELIVERY();
         retreive_customerCREDIT();
        customer_name01.setText("");
        customer_no.setText("");
        customer_addr.setText("");
        id_numberlabel1.setText("");
        quantity1.setText("0");
        quantity.setText("0");
        lblquantity.setText("");
        change.setText("");
        tender_amount.setText("");
        lblprice1.setText("");
        type.setSelectedItem("Type");
        date_chooser.setDate(new Date());
        balance1.setText("");
        
        
        }

    }//GEN-LAST:event_cartActionPerformed

    private void changeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeActionPerformed

    }//GEN-LAST:event_changeActionPerformed

    private void tender_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tender_amountActionPerformed

    }//GEN-LAST:event_tender_amountActionPerformed

    private void tender_amountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tender_amountKeyReleased
        balancePOS();
        // TODO add your handling code here:
    }//GEN-LAST:event_tender_amountKeyReleased

    private void lblprice1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblprice1ActionPerformed

    }//GEN-LAST:event_lblprice1ActionPerformed

    private void quantity1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quantity1MouseExited

    }//GEN-LAST:event_quantity1MouseExited

    private void quantity1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quantity1MouseReleased

    }//GEN-LAST:event_quantity1MouseReleased

    private void quantity1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantity1ActionPerformed
   
    }//GEN-LAST:event_quantity1ActionPerformed

    private void quantity1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_quantity1PropertyChange
        quantity1.setText("0");
    }//GEN-LAST:event_quantity1PropertyChange

    private void quantity1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantity1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantity1KeyPressed

    private void quantity1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantity1KeyReleased
typePOS();
    
    }//GEN-LAST:event_quantity1KeyReleased

    private void quantity1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantity1KeyTyped
         char vchar = evt.getKeyChar();
        if(!(Character.isDigit(vchar))){
            evt.consume(); }
    }//GEN-LAST:event_quantity1KeyTyped

    private void quantityMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quantityMouseExited

    }//GEN-LAST:event_quantityMouseExited

    private void quantityMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quantityMouseReleased

    }//GEN-LAST:event_quantityMouseReleased

    private void quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityActionPerformed
   
    }//GEN-LAST:event_quantityActionPerformed

    private void quantityPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_quantityPropertyChange
quantity.setText("0");    
    }//GEN-LAST:event_quantityPropertyChange

    private void quantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityKeyReleased
typePOS();       
         
    }//GEN-LAST:event_quantityKeyReleased

    private void quantityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityKeyTyped
  char vchar = evt.getKeyChar();
        if(!(Character.isDigit(vchar))){
            evt.consume(); }
    }//GEN-LAST:event_quantityKeyTyped

    private void typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeActionPerformed
        typePOS();

        String selectedOption = (String) type.getSelectedItem();
          if(selectedOption.equals("Type")){
    paid01.setEnabled(false);
        quantity.setText("0");
    quantity1.setText("0");
    }
    else if (selectedOption.equals("Walk-in")) {
       cart.setEnabled(false);
         paid01.setEnabled(true);
         
    } else if (selectedOption.equals("Delivery")) {
     
        cart.setEnabled(true);
        paid01.setEnabled(false);
         quantity.setText("0");
    quantity1.setText("0");
    }   
  
    }//GEN-LAST:event_typeActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
       datesaveDELIVERY();
        retreive_delivery();
        textarea.setText("");
    }//GEN-LAST:event_saveActionPerformed

    private void save1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save1ActionPerformed
         delete_dataDELIVERY();
        retreive_delivery();
        textarea.setText("");

        date_chooser.setDate(null);
    }//GEN-LAST:event_save1ActionPerformed

    private void sched_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sched_tableMouseClicked
        DefaultTableModel model=(DefaultTableModel) sched_table.getModel();
        int selectedRowIndex = sched_table.getSelectedRow();

        textarea.setText(model.getValueAt(selectedRowIndex,1).toString());
    }//GEN-LAST:event_sched_tableMouseClicked

    private void inventory_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventory_tableMouseClicked
/*DefaultTableModel model = (DefaultTableModel) inventory_table.getModel();
int selectedColumnIndex = inventory_table.getSelectedColumn();
int row = inventory_table.getSelectedRow();

if (row != -1) {
    Object value = model.getValueAt(row, selectedColumnIndex);

    switch (selectedColumnIndex) {
        case 0:
            item_name.setText(value.toString());
            break;
        case 1:
            quantity3.setText(value.toString());
            break;
        case 2:
            worth.setText(value.toString());
            break;
        case 3:
            return_gallon.setText(value.toString());
            break;
        case 4:
            fhs_gallon.setText(value.toString());
            break;
        default:
            // Handle any other columns if needed
            break;
    }
}
*/

  DefaultTableModel model = (DefaultTableModel) inventory_table.getModel();
        int selectedRowIndex = inventory_table.getSelectedRow();

        item_name.setText(model.getValueAt(selectedRowIndex, 0).toString());
        quantity3.setText(model.getValueAt(selectedRowIndex, 1).toString());
        worth.setText(model.getValueAt(selectedRowIndex, 2).toString());
          return_gallon.setText(model.getValueAt(selectedRowIndex, 3).toString());
        fhs_gallon.setText(model.getValueAt(selectedRowIndex, 4).toString());

    }//GEN-LAST:event_inventory_tableMouseClicked

    private void fhs_gallonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fhs_gallonKeyReleased
        int a = Integer.parseInt(quantity3.getText());
        int amt = a * 25;

        worth.setText("" + amt);
    }//GEN-LAST:event_fhs_gallonKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         update_itemINVENTORY();
        retreive_invetory();
        item_name.setText("");
        quantity3.setText("");
         worth.setText("");
          return_gallon.setText("");
          fhs_gallon.setText("");
     
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
       
          Inventory();
          retreive_invetory();
        item_name.setText("");
        quantity3.setText("");
        return_gallon.setText("");
         fhs_gallon.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void worthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_worthActionPerformed

    }//GEN-LAST:event_worthActionPerformed

    private void worthPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_worthPropertyChange
        worth.setVisible(false);
    }//GEN-LAST:event_worthPropertyChange

    private void worthKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_worthKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_worthKeyReleased

    private void customer_table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customer_table1MouseClicked
       DefaultTableModel model = (DefaultTableModel) customer_table1.getModel();
        int selectedRowIndex = customer_table1.getSelectedRow();
        customer_id1.setText(model.getValueAt(selectedRowIndex, 0).toString());
        customer_name1.setText(model.getValueAt(selectedRowIndex, 1).toString());
        customer_address1.setText(model.getValueAt(selectedRowIndex, 2).toString());
        customer_contact1.setText(model.getValueAt(selectedRowIndex, 3).toString());
    }//GEN-LAST:event_customer_table1MouseClicked

    private void search1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search1MouseClicked

    }//GEN-LAST:event_search1MouseClicked

    private void search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search1ActionPerformed

    }//GEN-LAST:event_search1ActionPerformed

    private void search1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search1KeyReleased
        
        searchCUSTOMER1();
    }//GEN-LAST:event_search1KeyReleased

    private void jPanel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel19MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel19MouseClicked

    private void jLabel37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel37MouseClicked

    private void id_numberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_numberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_numberActionPerformed

    private void id_numberPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_id_numberPropertyChange
        id_number.setVisible(false);
    }//GEN-LAST:event_id_numberPropertyChange

    private void id_numberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_id_numberKeyTyped
        char vchar = evt.getKeyChar();
        if(!(Character.isDigit(vchar))){
            evt.consume(); }
    }//GEN-LAST:event_id_numberKeyTyped

    private void c_name1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_name1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_name1ActionPerformed

    private void c_name1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_c_name1PropertyChange
   
    }//GEN-LAST:event_c_name1PropertyChange

    private void contact1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_contact1PropertyChange
       
    }//GEN-LAST:event_contact1PropertyChange

    private void address1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_address1PropertyChange
   
    }//GEN-LAST:event_address1PropertyChange

    private void paid01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paid01ActionPerformed

           int a = Integer.parseInt(quantity1.getText());
        int b = Integer.parseInt(quantity.getText());
        int add = a  * 15;
        int add1 = b * 15;
       

  DefaultTableModel model = (DefaultTableModel) reciept_table.getModel();
  model.addRow(new Object[]{"Gallon-Slim",quantity1.getText(), add});
   model.addRow(new Object[]{"Gallon-Round",quantity.getText(),add1});
 
                 String text = lblprice1.getText();
                 total_amountrc.setText(text);
        
        
        
        String selectedOption = (String) type.getSelectedItem();
  
        if(selectedOption.equals("Type")){
         JOptionPane.showMessageDialog(null, "There's no Type of Transaction Input.");
        }
        
       if (selectedOption.equals("Walk-in")) {
             update_inventoryPOS();
        PaidPOS();
          
        CreditPOS();
         gallonsPOS();
        retreive_POS();
        retrieve_paidcustomerPOS();
          new reciept().show();
          this.dispose();
         model.setRowCount(0);
    } if (selectedOption.equals("Delivery")) {
        PaidPOS();
            deliveryPOS();
        CreditPOS();
         gallonsPOS();
        retreive_POS();
        retrieve_paidcustomerPOS();
             retrieve_customerDELIVERY();
         retreive_customerCREDIT();
        model.setRowCount(0);
            delete_dataPOS();
          retreive_POS();
    }  
        customer_name01.setText("");
        customer_no.setText("");
        id_numberlabel1.setText("");
        customer_addr.setText("");
        type.setSelectedItem("Type");
        quantity1.setText("0");
        quantity.setText("0");
        lblquantity.setText("");
        lblprice1.setText("");
        balance1.setText("");
        change.setText("");
        tender_amount.setText("");
        date_chooser.setDate(new Date());
        total_amountrc.setText("");
        
       
    }//GEN-LAST:event_paid01ActionPerformed

    private void paid01MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paid01MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_paid01MouseClicked

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked
     delete_dataCUSTOMER();
     retreive_customer();
    }//GEN-LAST:event_deleteMouseClicked

    private void jLabel38MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel38MouseClicked
         update_customer s = new update_customer();
        s.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel38MouseClicked

    private void jPanel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel20MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel20MouseClicked

    private void jLabel32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MouseClicked
       new_customer s = new new_customer();
        s.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel32MouseClicked

    private void jPanel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel21MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel21MouseClicked

    private void credit_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_credit_tableMouseClicked

    }//GEN-LAST:event_credit_tableMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
               conn = DBconnection.conns();
        retreive_customerPOS();
        retrieve_paidcustomerPOS();
        retreive_POS();
  
        ////POS////
         retreive_delivery();
         retrieve_customerDELIVERY();
          ////DELIVERY////
           retreive_invetory();
            ////INVENTORY////
           retreive_customer();
            ////CUSTOMER////
            retreive_customerCREDIT();
           ////CREDIT////
    }//GEN-LAST:event_formWindowOpened

    private void customer_contact1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_customer_contact1PropertyChange
        customer_contact1.setVisible(false);
    }//GEN-LAST:event_customer_contact1PropertyChange

    private void customer_address1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_customer_address1PropertyChange
        customer_address1.setVisible(false);
    }//GEN-LAST:event_customer_address1PropertyChange

    private void customer_id1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_customer_id1PropertyChange
       customer_id1.setVisible(false);
    }//GEN-LAST:event_customer_id1PropertyChange

    private void customer_name1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_customer_name1PropertyChange
        customer_name1.setVisible(false);
    }//GEN-LAST:event_customer_name1PropertyChange

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
  customer_name01.setText("");
        customer_no.setText("");
        customer_addr.setText("");
        id_numberlabel1.setText("");
        quantity1.setText("0");
        quantity.setText("0");
        lblquantity.setText("");
        change.setText("");
        tender_amount.setText("");
        lblprice1.setText("");
        type.setSelectedItem("Type");  
        total_amountrc.setText("");
      
        date_chooser.setDate(new Date());
    }//GEN-LAST:event_jLabel20MouseClicked

    private void typeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_typeMouseClicked
        typePOS();
    }//GEN-LAST:event_typeMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       customer_name01.setText("");
        customer_no.setText("");
        customer_addr.setText("");
        id_numberlabel1.setText("");
        quantity1.setText("0");
        quantity.setText("0");
        lblquantity.setText("");
        change.setText("");
        tender_amount.setText("");
        lblprice1.setText("");
        type.setSelectedItem("Type");  
        total_amountrc.setText("");
      
        date_chooser.setDate(new Date());
    }//GEN-LAST:event_jButton3ActionPerformed

    private void quantity3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantity3KeyReleased

    }//GEN-LAST:event_quantity3KeyReleased

    private void return_gallonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_return_gallonKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_return_gallonKeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         item_name.setText("");
        quantity3.setText("");
        return_gallon.setText("");
         fhs_gallon.setText("");
        


    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
         
        
        delete_dataINVENTORY();
        retreive_invetory();

    }//GEN-LAST:event_jButton5ActionPerformed

    private void balance1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_balance1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_balance1ActionPerformed

    private void searchcreditKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchcreditKeyReleased
searchCredit();        // TODO add your handling code here:
    }//GEN-LAST:event_searchcreditKeyReleased

    private void searchdeliveryKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchdeliveryKeyReleased
     searchdelivery1();
    }//GEN-LAST:event_searchdeliveryKeyReleased

    private void textareaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_textareaPropertyChange
    textarea.setText("Scheduled Delivery\t\n");

   
    }//GEN-LAST:event_textareaPropertyChange

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(waterrefilling1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(waterrefilling1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(waterrefilling1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(waterrefilling1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new waterrefilling1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Delivery;
    private javax.swing.JLabel Delivery1;
    private javax.swing.JLabel Inventory;
    private javax.swing.JLabel POS;
    private javax.swing.JLabel Receipt;
    private javax.swing.JTextField address1;
    private javax.swing.JLabel asd;
    private javax.swing.JLabel asdd;
    private javax.swing.JLabel asddd;
    private javax.swing.JTextField balance1;
    private javax.swing.JLabel c_date;
    private javax.swing.JTextField c_name1;
    private javax.swing.JButton cart;
    private javax.swing.JTextField change;
    private javax.swing.JTextField contact1;
    private javax.swing.JPanel credit;
    private javax.swing.JLabel credit_dashboard;
    private javax.swing.JTable credit_table;
    private javax.swing.JPanel customer;
    private javax.swing.JLabel customer1;
    private javax.swing.JLabel customer_addr;
    private javax.swing.JLabel customer_address1;
    private javax.swing.JLabel customer_contact1;
    private javax.swing.JLabel customer_id1;
    private javax.swing.JLabel customer_name01;
    private javax.swing.JLabel customer_name1;
    private javax.swing.JLabel customer_no;
    private javax.swing.JTable customer_table;
    private javax.swing.JTable customer_table1;
    private javax.swing.JPanel dashboard;
    private javax.swing.JLabel dashboard1;
    private javax.swing.JLabel dashboard2;
    private com.toedter.calendar.JDateChooser date_chooser;
    private com.toedter.calendar.JDateChooser date_chooser1;
    private javax.swing.JLabel delete;
    private javax.swing.JLabel delivered_dashboard;
    private javax.swing.JPanel delivery;
    private javax.swing.JTable delivery_table;
    private javax.swing.JTextField fhs_gallon;
    private javax.swing.JLabel fhs_gallons1;
    private javax.swing.JLabel fhs_gallons2;
    private javax.swing.JTextField id_number;
    private javax.swing.JLabel id_numberlabel1;
    private javax.swing.JPanel inventory;
    private javax.swing.JTable inventory_table;
    private javax.swing.JTextField item_name;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblprice;
    private javax.swing.JTextField lblprice1;
    private javax.swing.JLabel lblquantity;
    private javax.swing.JButton paid01;
    private javax.swing.JTable paid_table;
    private javax.swing.JPanel panelBarChart;
    private javax.swing.JPanel panelLineChart;
    private javax.swing.JPanel panelLineChart1;
    private javax.swing.JPanel parentpanel;
    private javax.swing.JTable pos_table;
    private javax.swing.JTextField quantity;
    private javax.swing.JTextField quantity1;
    private javax.swing.JTextField quantity3;
    public static javax.swing.JTable reciept_table;
    private javax.swing.JTextField return_gallon;
    private javax.swing.JLabel sales_dashboard;
    private javax.swing.JButton save;
    private javax.swing.JButton save1;
    private javax.swing.JTable sched_table;
    private javax.swing.JTextField search;
    private javax.swing.JTextField search1;
    private javax.swing.JTextField searchcredit;
    private javax.swing.JTextField searchdelivery;
    private javax.swing.JLabel stocks_dashboard;
    private javax.swing.JLabel tc;
    public static javax.swing.JTextField tender_amount;
    private javax.swing.JTextArea textarea;
    private javax.swing.JLabel total;
    private javax.swing.JLabel total_amountrc;
    private javax.swing.JPanel transaction;
    private javax.swing.JComboBox type;
    private javax.swing.JTextField worth;
    // End of variables declaration//GEN-END:variables
   /////////////////POS CODES//////////////////////////////////
 /////////////////POS CODES//////////////////////////////////
     /////////////////POS CODES//////////////////////////////////
    private void balancePOS() {
        int price1 = Integer.parseInt(lblprice1.getText());
        int pay = Integer.parseInt(tender_amount.getText());
        int a;
        String selectedOption = (String) type.getSelectedItem();
if(price1 < pay){
        a = pay - price1;
     

    }else{
      a =price1 - pay;
    
}
if(selectedOption.equals("Walk-in")){
   change.setText(String.valueOf(a));
}
else if(selectedOption.equals("Delivery")){

    balance1.setText(String.valueOf(a));
}
   
    } 

    private void POS() {
          String name = customer_name01.getText();

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "There's no Customer Information Input.");
            return; // Exit the method without saving
        }
        
        try {
            String sql = "INSERT INTO pos(id_number,customer_name,address,type,contact,no_gallon,price,balance,date)VALUES(?,?,?,?,?,?,?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, id_numberlabel1.getText());
            pst.setString(2, name);
            pst.setString(3, customer_addr.getText());
            pst.setString(4, type.getSelectedItem().toString());
            pst.setString(5, customer_no.getText());
            pst.setString(6, lblquantity.getText());
            pst.setString(7, lblprice1.getText());
            pst.setString(8, balance1.getText());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(date_chooser.getDate());
            pst.setString(9, date);
            pst.execute();
         
                
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error on add to cart Transaction");
        }
    }
     private void deliveryPOS_PENDING() {
        try {
            String sql = "INSERT INTO delivery(id_number,customer_name,type,no_gallon,price,status,date)VALUES(?,?,?,?,?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, id_numberlabel1.getText());
            pst.setString(2, customer_name01.getText());
             pst.setString(3, type.getSelectedItem().toString());
            pst.setString(4, lblquantity.getText());
            pst.setString(5, lblprice1.getText());
            pst.setString(6, "Pending");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(date_chooser.getDate());
            pst.setString(7, date);

            pst.execute();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error on delivery save Transaction"+e);
        }
    }

    private void deliveryPOS() {
        try {
            String sql = "INSERT INTO delivery(id_number,customer_name,type,no_gallon,price,status,date)VALUES(?,?,?,?,?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, id_numberlabel1.getText());
            pst.setString(2, customer_name01.getText());
             pst.setString(3, type.getSelectedItem().toString());
            pst.setString(4, lblquantity.getText());
            pst.setString(5, lblprice1.getText());
            pst.setString(6, "Delivered");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(date_chooser.getDate());
            pst.setString(7, date);

            pst.execute();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error on delivery save Transaction");
        }
    }
     /* private void PaidPOS() {
        
        try{
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM paid WHERE name = '"+  customer_name01.getText()+ "'");
        ResultSet rset = ps.executeQuery();
        if(rset.next()){
        JOptionPane.showMessageDialog(null, "No Customer Name");
        } else {
        String sql = "INSERT INTO paid(id_number,name,address,type,contact,no_gallon,price,balance,date)VALUES(?,?,?,?,?,?,?,?,?)";
            pst = conn.prepareStatement(sql);
            
            pst.setString(1, id_numberlabel1.getText());
            pst.setString(2, customer_name01.getText());
            pst.setString(3, customer_addr.getText());
            pst.setString(4, type.getSelectedItem().toString());
            pst.setString(5, customer_no.getText());
            pst.setString(6, lblquantity.getText());
            pst.setString(7, lblprice1.getText());
            pst.setString(8, "Paid");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(date_chooser.getDate());
            pst.setString(9, date);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Paid Customer");
      
        }
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
        
        }
    }*/ 
    /*   private void PaidPOS() {
    try {
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM paid WHERE name = ?");
        ps.setString(1, customer_name01.getText());
        ResultSet rset = ps.executeQuery();
        
        if (rset.next()) {
            JOptionPane.showMessageDialog(null, "Customer Name already exists");
        } else {
            String sql = "INSERT INTO paid (id_number, name, address, type, contact, no_gallon, price, balance, date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pst = conn.prepareStatement(sql);

            pst.setString(1, id_numberlabel1.getText());
            pst.setString(2, customer_name01.getText());
            pst.setString(3, customer_addr.getText());
            pst.setString(4, type.getSelectedItem().toString());
            pst.setString(5, customer_no.getText());
            pst.setString(6, lblquantity.getText());
            pst.setString(7, lblprice1.getText());
            pst.setString(8, "Paid");

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(date_chooser.getDate());
            pst.setString(9, date);

            pst.execute();
            JOptionPane.showMessageDialog(null, "Customer Paid");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
}*/ 
private void PaidPOS() {
    try {
        String name = customer_name01.getText();
        
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a name.");
            return; // Exit the method without saving
        }
        
        String sql = "INSERT INTO paid(id_number, name, address, type, contact, no_gallon, price, balance, date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        pst = conn.prepareStatement(sql);
        
        pst.setString(1, id_numberlabel1.getText());
        pst.setString(2, name);
        pst.setString(3, customer_addr.getText());
        pst.setString(4, type.getSelectedItem().toString());
        pst.setString(5, customer_no.getText());
        pst.setString(6, lblquantity.getText());
        pst.setString(7, lblprice1.getText());
        pst.setString(8, "Paid");
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(date_chooser.getDate());
        pst.setString(9, date);
        
        pst.execute();
        JOptionPane.showMessageDialog(null, "Paid Customer");

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error on Paid customer Transaction");
    }
}


    /*private void PaidPOS() {
        try {
            String sql = "INSERT INTO paid(id_number,name,address,type,contact,no_gallon,price,balance,date)VALUES(?,?,?,?,?,?,?,?,?)";
            pst = conn.prepareStatement(sql);
            
            pst.setString(1, id_numberlabel1.getText());
            pst.setString(2, customer_name01.getText());
            pst.setString(3, customer_addr.getText());
            pst.setString(4, type.getSelectedItem().toString());
            pst.setString(5, customer_no.getText());
            pst.setString(6, lblquantity.getText());
            pst.setString(7, lblprice1.getText());
            pst.setString(8, "Paid");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(date_chooser.getDate());
            pst.setString(9, date);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Paid Customer");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    } */
    
    private void CreditPOS() {
        try {
            String sql = "INSERT INTO credit(number_id,name,address,contact,no_gallon,balance,date)VALUES(?,?,?,?,?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, id_numberlabel1.getText());
            pst.setString(2, customer_name01.getText());
            pst.setString(3, customer_addr.getText());
            pst.setString(4, customer_no.getText());
            pst.setString(5, lblquantity.getText());
            pst.setString(6, balance1.getText());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(date_chooser.getDate());
            pst.setString(7, date);
            pst.execute();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error on add to credit Transaction"+e);
        }
    }

    private void retrieve_paidcustomerPOS() {
        try {
            String sql = "SELECT  id_number AS 'ID Number',name AS 'Customer Name', address AS 'Address', type AS 'Type', contact AS 'Contact', no_gallon AS 'No of Gallon', price AS 'Price', balance AS 'Balance', date AS 'Date' FROM paid";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
         //paid_table.setModel(DbUtils.resultSetToTableModel(rs));
       DefaultTableModel dtm = (DefaultTableModel)paid_table.getModel();
        dtm.setRowCount(0);
        int total1 = 0;
      while(rs.next()){
            
            total1 = total1 + rs.getInt("Price");
            Object o[]={rs.getString("ID Number"),rs.getString("Customer Name"),rs.getString("Address"),rs.getString("Type"),rs.getString("Contact"),rs.getString("No of Gallon"),rs.getString("Price"),rs.getString("Balance"), rs.getString("Date")};
            dtm.addRow(o);
        
       }
      sales_dashboard.setText(Integer.toString(total1)); 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, "Error on retrieving paid customer Transaction");
        }
    }

    private void retreive_POS() {
        try {
            String sql = "SELECT  id_number AS 'ID Number', customer_name AS 'Customer Name', address AS 'Address', type AS 'Type', contact AS 'Contact', no_gallon AS 'No of Gallon', price AS 'Price', balance AS 'Balance', date AS 'Date' FROM pos";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            pos_table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error on retrieving add to cart Transaction");
        }
    }

    private void retreive_customerPOS() {
        try {
            String sql = "SELECT  id_number AS 'ID Number', customer_name AS 'Customer Name', address AS 'Address', contact AS 'Contact' FROM customer";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            customer_table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error on retrieving customer to Transaction");
        }
    }

 

    private void delete_dataPOS() {
        try {
            String sql = "DELETE FROM pos WHERE id_number = '" + id_numberlabel1.getText() + "'";
            pst = conn.prepareStatement(sql);
            pst.execute();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error on deleting data to Transaction");
        }
    }



   private void searchPOS1() {
    try {
        String searchTerm = search.getText();
        String searchValue = "%" + searchTerm + "%";

        String sql = "SELECT id_number AS 'ID Number', customer_name AS 'Customer Name', address AS 'Address', contact AS 'Contact' " +
                "FROM customer " +
                "WHERE id_number LIKE ? OR customer_name LIKE ? OR address LIKE ? OR contact LIKE ?";

        pst = conn.prepareStatement(sql);
        pst.setString(1, searchValue);
        pst.setString(2, searchValue);
        pst.setString(3, searchValue);
        pst.setString(4, searchValue);

        rs = pst.executeQuery();
        customer_table.setModel(DbUtils.resultSetToTableModel(rs));
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error on searching for customer to Transaction");
    }
}

 private void typePOS() {
    String selectedOption = (String) type.getSelectedItem();
    int quantityValue = 0;
    int quantity1Value = 0;
    try {
        quantityValue = Integer.parseInt(quantity.getText());
        quantity1Value = Integer.parseInt(quantity1.getText());
    } catch (NumberFormatException e) {
        // Handle the exception if the input cannot be parsed as an integer
        // Display an error message or perform appropriate error handling
         JOptionPane.showMessageDialog(null, "Error on combox cannot be parsed as an integer in Transaction");
        return;
    }
    
    int totalQuantity = quantityValue + quantity1Value;
    int totalPrice = 0;
    if(selectedOption.equals("Type")){
    paid01.setEnabled(false);
    }
    else if (selectedOption.equals("Walk-in")) {
        totalPrice = totalQuantity * 15;
        cart.setEnabled(false);
           paid01.setEnabled(true);
    } else if (selectedOption.equals("Delivery")) {
        totalPrice = totalQuantity * 20;
        cart.setEnabled(true);
        paid01.setEnabled(true);
    }
    
    lblquantity.setText(String.valueOf(totalQuantity));
    lblprice1.setText(String.valueOf(totalPrice));
}
  
 
 


    private void gallonsPOS() {
        try {
            String sql = "INSERT INTO gallon(gallon_slim,gallon_round)VALUES(?,?)";
            pst = conn.prepareStatement(sql);

            pst.setString(1, quantity1.getText());
            pst.setString(2, quantity.getText());
            pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error on retrieving gallons to Transaction");
        }
    }


    private void update_inventoryPOS() {
    int slim = 0;
    int round = 0;
    int priceslim = 0;
    int priceround = 0;
    
    if (!quantity1.getText().isEmpty()) {
        slim = Integer.parseInt(quantity1.getText());
        priceslim = slim * 15;
    }
    if (!quantity.getText().isEmpty()) {
        round = Integer.parseInt(quantity.getText());
        priceround = round * 15;
    }
    
    try {
        PreparedStatement ps1 = conn.prepareStatement("UPDATE inventory SET quantity = quantity - ?, worth = worth - ? WHERE item_name = 'gallon-slim'");
        ps1.setInt(1, slim);
        ps1.setInt(2, priceslim);
        ps1.executeUpdate();

        PreparedStatement ps2 = conn.prepareStatement("UPDATE inventory SET quantity = quantity - ?, worth = worth - ? WHERE item_name = 'gallon-round'");
        ps2.setInt(1, round);
        ps2.setInt(2, priceround);
        ps2.executeUpdate();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error on updating inventory level in Transaction");
    }
}


 /////////////////POS CODES//////////////////////////////////
    /////////////////POS CODES//////////////////////////////////
 /////////////////POS CODES//////////////////////////////////

       private void datesaveDELIVERY(){
      try{
          String sql = "INSERT INTO sched_delivery(date,description)VALUES(?,?)";
          pst = conn.prepareStatement(sql);
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
          String date = sdf.format(date_chooser1.getDate());
          pst.setString(1,date);
          pst.setString(2,textarea.getText());         
          pst.execute();
       
          JOptionPane.showMessageDialog(rootPane, "data saved");
      }catch(Exception e){
          JOptionPane.showMessageDialog(null,"Error on saving data on delivery");
      }  
    }

private void retreive_delivery(){
        try{
        String sql = "SELECT  date AS 'DATE', description AS 'Description' FROM sched_delivery";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
       sched_table.setModel(DbUtils.resultSetToTableModel(rs));
            sched_table.getColumnModel().getColumn(1).setMinWidth(0);
         sched_table.getColumnModel().getColumn(1).setMaxWidth(0);
       
        } catch(Exception e){
         JOptionPane.showMessageDialog(rootPane, "Error on retrieving data on delivery"+e);
        }
}         
  private void retrieve_customerDELIVERY(){
        try{
        String sql = "SELECT  id_number AS 'ID Number',customer_name AS 'Customer Name', type AS 'Type', no_gallon AS 'No of Gallon', price AS 'Price', status AS 'Status', date AS 'Date' FROM delivery";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        delivery_table.setModel(DbUtils.resultSetToTableModel(rs));

        
        
        } catch(Exception e){
         JOptionPane.showMessageDialog(rootPane, "Error on retrieving data on customer delivery");
        }
}
  
 private void delete_dataDELIVERY(){
    try{
        String sql = "DELETE FROM sched_delivery WHERE description = '"+textarea.getText()+"'";
        pst = conn.prepareStatement(sql);
        pst.execute();
        JOptionPane.showMessageDialog(rootPane, "Task Deleted");
    
    }catch(Exception e){
    JOptionPane.showMessageDialog(null, "Error on Deleting Data on Delivery");
}
} 
 private void searchdelivery1() {
    try {
        String searchTerm = searchdelivery.getText();
        String searchValue = "%" + searchTerm + "%";

        String sql = "SELECT id_number AS 'ID Number', customer_name AS 'Customer Name', type AS 'Type', no_gallon AS 'No. of Gallons', price AS 'Price', status AS 'Status', date AS 'Date'" +
                "FROM delivery " +
                "WHERE id_number LIKE ? OR customer_name LIKE ? OR type LIKE ? OR no_gallon LIKE ? OR price LIKE ? OR status LIKE ? OR date LIKE ?";

        pst = conn.prepareStatement(sql);
        pst.setString(1, searchValue);
        pst.setString(2, searchValue);
          pst.setString(3, searchValue);
        pst.setString(4, searchValue);
          pst.setString(5, searchValue);
        pst.setString(6, searchValue);
        pst.setString(7, searchValue);

        rs = pst.executeQuery();
        delivery_table.setModel(DbUtils.resultSetToTableModel(rs));
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error on searching data on Delivery"+e);
    }
}
   /////////////////delivery CODES//////////////////////////////////
 /////////////////delivery CODES//////////////////////////////////
 /////////////////delivery CODES//////////////////////////////////
 
  /////////////////CUSTOMER CODES//////////////////////////////////
 /////////////////CUSTOMER CODES//////////////////////////////////
 /////////////////CUSTOMER CODES//////////////////////////////////
 
 private void retreive_customer(){
        try{
        String sql = "SELECT  id_number AS 'ID Number', customer_name AS 'Customer Name', address AS 'Address', contact AS 'Contact' FROM customer";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        customer_table1.setModel(DbUtils.resultSetToTableModel(rs));

        } catch(Exception e){
         JOptionPane.showMessageDialog(rootPane, "Error on retrieving data on Customer");
        }
}

private void update_customer(){
        try{

           String sql = "UPDATE customer SET customer_name = ?,  address = ?, contact = ? WHERE customer_name = '"+c_name1.getText()+"'";
            pst = conn.prepareStatement(sql);
            pst.setString(2, c_name1.getText());
            pst.setString(3,(String)address1.getText());
            pst.setString(4, contact1.getText());
           
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data Updated Successfully");
            
            
}catch(Exception e){
        JOptionPane.showMessageDialog(rootPane, "Error on updating data on Customer");
        }
}


    

private void searchCUSTOMER1() {
    try {
        String searchTerm = search1.getText();
        String searchValue = "%" + searchTerm + "%";

        String sql = "SELECT id_number AS 'ID Number', customer_name AS 'Customer Name', address AS 'Address', contact AS 'Contact' " +
                "FROM customer " +
                "WHERE id_number LIKE ? OR customer_name LIKE ? OR address LIKE ? OR contact LIKE ?";

        pst = conn.prepareStatement(sql);
        pst.setString(1, searchValue);
        pst.setString(2, searchValue);
        pst.setString(3, searchValue);
        pst.setString(4, searchValue);

        rs = pst.executeQuery();
        customer_table1.setModel(DbUtils.resultSetToTableModel(rs));
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error on searching data on Customer");
    }
}


 private void delete_dataCUSTOMER() {
        try {
            String sql = "DELETE FROM customer WHERE id_number = '" + customer_id1.getText() + "'";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Customer Information Deleted");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error on deleting data on Customer");
        }
    }

 /////////////////CUSTOMER CODES//////////////////////////////////
 /////////////////CUSTOMER CODES//////////////////////////////////
 /////////////////CUSTOMER CODES//////////////////////////////////
 
    /////////////////INVENTORY CODES//////////////////////////////////
 /////////////////INVENTORY CODES//////////////////////////////////
 /////////////////INVENTORY CODES//////////////////////////////////
private void Inventory() {
    try {
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM inventory WHERE item_name = ?");
        ps.setString(1, item_name.getText());
        ResultSet rset = ps.executeQuery();
        if (rset.next()) {
            JOptionPane.showMessageDialog(null, "Item is already added");
        } else {
            String sql = "INSERT INTO inventory(item_name, quantity, worth, return_gallon, fhs_gallon, date) VALUES (?, ?, ?, ?, ?, ?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, item_name.getText());
            pst.setString(2, quantity3.getText());
            pst.setString(3, worth.getText());
            pst.setString(4, return_gallon.getText());
            pst.setString(5, fhs_gallon.getText());
            LocalDateTime currentDateTime = LocalDateTime.now();
            Timestamp currentTimestamp = Timestamp.valueOf(currentDateTime);
            pst.setTimestamp(6, currentTimestamp);

            pst.execute();
            JOptionPane.showMessageDialog(null, "Item Added");
        }
    } catch (HeadlessException | SQLException e) {
        JOptionPane.showMessageDialog(null, "Error on saving data on UInventory");
    }
}





    private void retreive_invetory() {
        try {
            String sql = "SELECT item_name AS 'Item Name', quantity AS 'Quantity', worth AS 'Worth', return_gallon AS 'Return Gallons', fhs_gallon AS 'FHS Gallons', date AS 'Date' FROM inventory";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
     inventory_table.getColumnModel().getColumn(4).setMinWidth(0);
        inventory_table.getColumnModel().getColumn(4).setMaxWidth(0);               
      
   DefaultTableModel dtm = (DefaultTableModel)inventory_table.getModel();
   
   
        dtm.setRowCount(0);
        int total1 = 0;
        int rowCounter = 0;
        
        while(rs.next()){
            total1 = total1 + rs.getInt("Quantity");
            int fhsGallons = rs.getInt("FHS Gallons");
            Object o[]={rs.getString("Item Name"),rs.getString("Quantity"),rs.getString("Worth"),rs.getString("Return Gallons"),rs.getString("FHS Gallons"),rs.getString("Date")};
            dtm.addRow(o);
               if (rowCounter == 0) {
                fhs_gallons1.setText(Integer.toString(fhsGallons));
            } else if (rowCounter == 1) {
                fhs_gallons2.setText(Integer.toString(fhsGallons));
            }
               rowCounter++;
        }
         stocks_dashboard.setText(Integer.toString(total1));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error on retrieving data on Inventory" + e);
        }
    }
 private void update_itemINVENTORY() {
     int qty = 0;
     int price = 0;
     
     if(item_name.getText().equals ("gallon-slim")){
     if(!quantity3.getText().isEmpty() || !return_gallon.getText().isEmpty() || !fhs_gallon.getText().isEmpty()){
        qty= Integer.parseInt(quantity3.getText());
         Integer.parseInt(return_gallon.getText());
         Integer.parseInt(fhs_gallon.getText());    
         price = qty * 20;
     }
     else{
            JOptionPane.showMessageDialog(null, "Data Updated Unsuccessfully");
     }
     }
     else if(item_name.getText().equals("gallon-round")){
         if(!quantity3.getText().isEmpty() || !return_gallon.getText().isEmpty() || !fhs_gallon.getText().isEmpty()){
                 qty= Integer.parseInt(quantity3.getText());
         Integer.parseInt(return_gallon.getText());
         Integer.parseInt(fhs_gallon.getText());    
            price = qty * 25;
         }
         else{
                JOptionPane.showMessageDialog(null, "Data Updated Unsuccessfully");
         }
     }
     else {
          JOptionPane.showMessageDialog(null, "all Data Updated Unsuccessfully");
     }
     
     
    try {
        String sql = "UPDATE inventory SET item_name = ?, quantity = quantity + ?, worth = worth + ?, return_gallon = return_gallon + ?, fhs_gallon = fhs_gallon + ?, date = ? WHERE item_name = item_name + ?";
        pst = conn.prepareStatement(sql);
        pst.setString(1, item_name.getText());
        pst.setInt(2, qty);
        pst.setInt(3, price);
        pst.setString(4, return_gallon.getText());
        pst.setString(5, fhs_gallon.getText());
        
        // Get the current timestamp
        LocalDateTime currentDateTime = LocalDateTime.now();
        Timestamp currentTimestamp = Timestamp.valueOf(currentDateTime);
        pst.setTimestamp(6, currentTimestamp);
        
        pst.setString(7, item_name.getText()); // Update condition
        
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null, "Data Updated Successfully");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(rootPane, "Error on updating data on Inventory: " + e.getMessage());
    }
}
 /*private void update_itemINVENTORY() {
    try {
        String sql = "UPDATE inventory SET item_name = ?, quantity = ?, worth = ?, return_gallon = ?, fhs_gallon = ?, date = ? WHERE item_name = ?";
        pst = conn.prepareStatement(sql);
        pst.setString(1, item_name.getText());
        pst.setString(2, quantity3.getText());
        pst.setString(3, worth.getText());
        pst.setString(4, return_gallon.getText());
        pst.setString(5, fhs_gallon.getText());
        
        // Get the current timestamp
        LocalDateTime currentDateTime = LocalDateTime.now();
        Timestamp currentTimestamp = Timestamp.valueOf(currentDateTime);
        pst.setTimestamp(6, currentTimestamp);
        
        pst.setString(7, item_name.getText()); // Update condition
        
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null, "Data Updated Successfully");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(rootPane, "Error on updating data on Inventory: " + e.getMessage());
    }
}*/
 
private void delete_dataINVENTORY() {
    try {
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to reset the value?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            String sql = "DELETE FROM inventory";
            pst = conn.prepareStatement(sql);
                    item_name.setText("");
        quantity3.setText("");
        return_gallon.setText("");
         worth.setText("");
         fhs_gallon.setText("");
         fhs_gallons1.setText("");
         fhs_gallons2.setText("");
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data has reset to INVENTORY");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error on deleting data to INVENTORY: " + e);
    }
}


     /////////////////INVENTORY CODES//////////////////////////////////
 /////////////////INVENTORY CODES//////////////////////////////////
 /////////////////INVENTORY CODES//////////////////////////////////
    
    
        /////////////////CREDIT CODES//////////////////////////////////
 /////////////////CREDIT CODES//////////////////////////////////
 /////////////////CREDIT CODES//////////////////////////////////
    private void retreive_customerCREDIT(){
        try{
        String sql = "SELECT  number_id AS 'ID Number',name AS 'Customer Name', address AS 'Address', contact AS 'Contact', no_gallon AS 'No of Gallon', balance AS 'Balance', date AS 'Date' FROM credit";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        
        DefaultTableModel dtm = (DefaultTableModel)credit_table.getModel();
        dtm.setRowCount(0);
        int total1 = 0;
        while(rs.next()){
            
            total1 = total1 + rs.getInt("Balance");
            Object o[]={rs.getString("ID Number"),rs.getString("Customer Name"),rs.getString("Address"),rs.getString("Contact"),rs.getString("No of Gallon"),rs.getString("Balance"), rs.getString("Date")};
            dtm.addRow(o);
        }
        total.setText(Integer.toString(total1));
        credit_dashboard.setText(Integer.toString(total1));
        } catch(SQLException e){
         JOptionPane.showMessageDialog(rootPane, "Error on reteiving Customer balance in Uncollectible");
        }
}
private void searchCredit() {
    try {
        String searchTerm = searchcredit.getText();
        String searchValue = "%" + searchTerm + "%";

        String sql = "SELECT number_id AS 'ID', name AS 'Customer Name', address AS 'Address', contact AS 'Contact', no_gallon AS 'No. of Gallons', balance AS 'Balance', date AS 'Date' " +
                "FROM credit " +
                "WHERE number_id LIKE ? OR name LIKE ? OR address LIKE ? OR contact LIKE ? OR no_gallon LIKE ? OR balance LIKE ? OR date LIKE ?";

        pst = conn.prepareStatement(sql);
        pst.setString(1, searchValue);
        pst.setString(2, searchValue);
        pst.setString(3, searchValue);
        pst.setString(4, searchValue);
         pst.setString(5, searchValue);
          pst.setString(6, searchValue);
           pst.setString(7, searchValue);

        rs = pst.executeQuery();
        credit_table.setModel(DbUtils.resultSetToTableModel(rs));
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error on searching data on Uncollectible");
    }
}
 


}



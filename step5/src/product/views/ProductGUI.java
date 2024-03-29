package product.views;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.util.*;

import product.controller.ProductController;
import product.model.dao.*;
import product.model.vo.*;

public class ProductGUI extends JFrame{	
	private JTable listTable;
	private TableModel dataModel;
	private JScrollPane tablePane;

	private JPanel searchPane;
	private Checkbox pIdCheck;
	private Checkbox pNameCheck;
	private JTextField tfSearchText;

	private JPanel detailPane;
	private JTextField tfProductId;
	private JTextField tfProductName;
	private JSpinner spPrice;
	private JTextField tfDescription;	

	public ProductGUI(){
		super("상품 관리 프로그램");

		//전체 화면 크기 얻어와서, 프레임 크기로 지정함
		/*Toolkit tk=Toolkit.getDefaultToolkit();
		this.setSize(tk.getScreenSize());*/

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocation(500, 300);

		makeJTable(this);
		makeSearchPane(this);
		makeDetailPane(this);

		JPanel eastPane = new JPanel();
		eastPane.setLayout(new BorderLayout());
		eastPane.add(searchPane, BorderLayout.NORTH);
		eastPane.add(detailPane, BorderLayout.CENTER);

		this.add(tablePane, BorderLayout.CENTER);
		this.add(eastPane, BorderLayout.EAST);

		this.pack();
		this.setVisible(true);
	}

	//전체 조회시
	public TableModel displayListAll(){
		String[] columnNames = 
			{"product_id", "p_name", "price", "description"};

		Object[][] data = null;
		ProductController pc = new ProductController();
		ArrayList<Product> list = pc.selectList();

		data = new Object[list.size()][];

		for(int i = 0; i < list.size(); i++){
			data[i] = new Object[4];
			Product p = list.get(i);

			data[i][0] = p.getpId();
			data[i][1] = p.getpName();
			data[i][2] = p.getPrice();
			data[i][3] = p.getDesc();
		}

		dataModel = new DefaultTableModel(data, columnNames);

		return dataModel;
	}

	//상품명으로 조회시
	public TableModel displayListName(){
		String[] columnNames = 
			{"product_id", "p_name", "price", "description"};

		Object[][] data = null;
		ProductController pc = new ProductController();
		ArrayList<Product> list = pc.selectName(tfSearchText.getText());
		
		if(list.size() == 0){
			return displayListAll();
		}
		data = new Object[list.size()][];

		for(int i = 0; i < list.size(); i++){
			data[i] = new Object[4];
			Product p = list.get(i);

			data[i][0] = p.getpId();
			data[i][1] = p.getpName();
			data[i][2] = p.getPrice();
			data[i][3] = p.getDesc();
		}

		dataModel = new DefaultTableModel(data, columnNames);

		return dataModel;
	}

	//상품 아이디로 조회시
	public TableModel displayListOne(){
		String[] columnNames = 
			{"product_id", "p_name", "price", "description"};

		Object[][] data = null;
		ProductController pc = new ProductController();
		Product p = pc.selectId(tfSearchText.getText());

		if(p == null){
			return displayListAll();
		}

		data = new Object[1][];		
		data[0] = new Object[4];			
		data[0][0] = p.getpId();
		data[0][1] = p.getpName();
		data[0][2] = p.getPrice();
		data[0][3] = p.getDesc();		

		dataModel = new DefaultTableModel(data, columnNames);

		return dataModel;
	}

	public void makeJTable(JFrame f){
		listTable = new JTable(displayListAll());
		tablePane = new JScrollPane(listTable);

		listTable.setFillsViewportHeight(true);
		listTable.setAutoCreateRowSorter(true);

		tablePane.setPreferredSize(new Dimension(450, 350));

		listTable.addMouseListener(new TableItemSelection());

	}	

	public void makeDetailPane(JFrame f){
		detailPane = new JPanel();
		detailPane.setSize(new Dimension(300, 200));

		tfProductId = new JTextField(20);
		tfProductName = new JTextField(20);

		SpinnerModel numberModel = 
				new SpinnerNumberModel(1000000, 10000, 90000000, 10000);
		spPrice = new JSpinner(numberModel);
		spPrice.setSize(new Dimension(200, 30));
		tfDescription = new JTextField(20);

		JButton insertBtn = new JButton("추가");
		insertBtn.addActionListener(new InsertBtnEvent());
		JButton updateBtn = new JButton("수정");
		updateBtn.addActionListener(new UpdateBtnEvent());
		JButton deleteBtn = new JButton("삭제");
		deleteBtn.addActionListener(new DeleteBtnEvent());

		JPanel centerPane = new JPanel();
		centerPane.setLayout(new GridLayout(6, 1));

		JPanel tempPane = new JPanel();
		tempPane.add(new JLabel(" "));
		centerPane.add(tempPane);

		JPanel titlePane = new JPanel();
		titlePane.add(new JLabel("----- 상세 보기 -----"));
		centerPane.add(titlePane);

		JPanel p1 = new JPanel();
		p1.add(new JLabel("상품  ID : "));
		p1.add(tfProductId);
		centerPane.add(p1);

		JPanel p2 = new JPanel();
		p2.add(new JLabel("상 품 명 : "));
		p2.add(tfProductName);
		centerPane.add(p2);

		JPanel p3 = new JPanel();		
		p3.add(new JLabel("가       격 : "));
		p3.add(new JLabel(".                            ."));
		p3.add(spPrice);
		centerPane.add(p3);

		JPanel p4 = new JPanel();
		p4.add(new JLabel("상품설명 : "));
		p4.add(tfDescription);
		centerPane.add(p4);

		JPanel southPane = new JPanel();
		southPane.add(insertBtn);
		southPane.add(updateBtn);
		southPane.add(deleteBtn);

		detailPane.setLayout(new BorderLayout());
		detailPane.add(centerPane, BorderLayout.CENTER);
		detailPane.add(southPane, BorderLayout.SOUTH);
	}

	public void makeSearchPane(JFrame f){
		searchPane = new JPanel();
		searchPane.setSize(new Dimension(300, 150));

		CheckboxGroup chkGroup = new CheckboxGroup();
		pIdCheck = new Checkbox("Product ID", chkGroup, true);
		pNameCheck = new Checkbox("Product Name", chkGroup, false);
		JButton listBtn = new JButton("목록 보기");
		listBtn.addActionListener(new ListBtnEvent());

		tfSearchText = new JTextField(20);
		JButton searchBtn = new JButton("검색");
		searchBtn.addActionListener(new SearchBtnEvent());

		JPanel topPane = new JPanel();
		topPane.add(pIdCheck);
		topPane.add(pNameCheck);
		topPane.add(listBtn);

		JPanel bottomPane = new JPanel();
		bottomPane.add(tfSearchText);
		bottomPane.add(searchBtn);

		searchPane.setLayout(new GridLayout(2, 1));
		searchPane.add(topPane);
		searchPane.add(bottomPane);

	}

	//테이블의 상품 아이디 클릭시 작동되는 이벤트 핸들러
	class TableItemSelection extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e){
			int row = listTable.getSelectedRow();
			if(row >= 0){
				String pId = (String)listTable.getValueAt(row, 0);
				ProductController pc = new ProductController();
				Product p = pc.selectId(pId);
				
				tfProductId.setText(p.getpId());
				tfProductName.setText(p.getpName());
				spPrice.setValue(p.getPrice());
				tfDescription.setText(p.getDesc());			
			}

		}
	}

	//목록 보기 버튼 클릭시 작동되는 이벤트 핸들러
	class ListBtnEvent implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			listTable.setModel(displayListAll());
		}
	}

	//검색 버튼 클릭시 작동되는 이벤트 핸들러
	class SearchBtnEvent implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){			
			if(pIdCheck.getState() == true)
				listTable.setModel(displayListOne());
			else if(pNameCheck.getState() == true)
				listTable.setModel(displayListName());
		}
	}

	//추가 버튼 클릭시 작동되는 이벤트 핸들러
	class InsertBtnEvent implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			ProductController pc = new ProductController();
			Product p = new Product();
			p.setpId(tfProductId.getText());
			p.setpName(tfProductName.getText());
			p.setPrice((Integer)spPrice.getValue());
			p.setDesc(tfDescription.getText());

			if(pc.insertRow(p) > 0){					
				listTable.setModel(displayListAll());			
			}
		}
	}

	//수정 버튼 클릭시 작동되는 이벤트 핸들러
	class UpdateBtnEvent implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			ProductController pc = new ProductController();

			String pId = tfProductId.getText();
			int price = (Integer)spPrice.getValue();

			if(pc.updateRow(pId, price) > 0){					
				listTable.setModel(displayListAll());			
			}
		}
	}

	//삭제 버튼 클릭시 작동되는 이벤트 핸들러
	class DeleteBtnEvent implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			ProductController pc = new ProductController();

			if(pc.deleteRow(tfProductId.getText()) > 0){					
				listTable.setModel(displayListAll());			
			}
		}
	}
}

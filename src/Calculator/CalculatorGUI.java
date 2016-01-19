package Calculator;

import java.awt.*;
import java.sql.*;
import java.util.zip.*;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class CalculatorGUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Connection connection = null;
	File file=null;
	private JButton btnNewButton;
	private JButton btnGzipFile;
	FileInputStream file_input,file_input_unzip=null;
	FileOutputStream file_output=null, file_output_unzip=null;
	private JButton btnUnzipFile;
	private JButton btnUngzipFile;
	private JButton btnUploadFile;
	FileReader reader=null;
	BufferedReader br1=null;
	ZipInputStream zip=null;
	ZipEntry entry=null;
	String filename=null;
	String directory=null;
	private JButton btnSelectDefault;
	private JLabel label1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorGUI frame = new CalculatorGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CalculatorGUI() {
		
		this.setTitle("History");
		connection = databaseConnection.connector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 446, 330);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(Color.black);
		table.setForeground(Color.white);
		scrollPane.setViewportView(table);
		contentPane.setBackground(Color.BLACK);
		contentPane.setForeground(Color.white);
		
		try{
			String query1 = "select * from Calculator";
			PreparedStatement pst = connection.prepareStatement(query1);
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			JButton btnSaveInFile = new JButton("Save in File");
			btnSaveInFile.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					file= new File("C:\\Users\\aelay\\Desktop\\data.txt");
					 TableModel model = table.getModel();
					 int row = model.getRowCount(),col = model.getColumnCount();
					 Object[][] tableData = new Object[row][col];

						try {
							if(!file.exists())
							file.createNewFile();
							
							FileWriter file_writer = new FileWriter(file.getAbsoluteFile());
							BufferedWriter buffer_writer = new BufferedWriter(file_writer);
						    for (int i = 0 ; i < row ; i++)
						        for (int j = 0 ; j < col ; j++){
						            tableData[i][j] = model.getValueAt(i,j);
							buffer_writer.write(tableData[i][j].toString());
							JOptionPane.showMessageDialog(null, "File saved at C:\\Users\\aelay\\Desktop\\data.txt");
						        }
							buffer_writer.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null,e);
						}
					
					
					
					
				}
			});
			btnSaveInFile.setBounds(449, 4, 113, 25);
			contentPane.add(btnSaveInFile);
			
			btnNewButton = new JButton("ZIP File");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					byte[] buffer_byte = new byte[1024];
					try {
						FileOutputStream fileos = new FileOutputStream("C:\\Users\\aelay\\Desktop\\data.zip");
						ZipOutputStream zipos = new ZipOutputStream(fileos);
						ZipEntry zipentry= new ZipEntry("data.txt");
						try {
							zipos.putNextEntry(zipentry);
							FileInputStream in = new FileInputStream(file.toString());
							int length=0;
							while((length = in.read(buffer_byte))>0){
								zipos.write(buffer_byte, 0, length);
							}
							JOptionPane.showMessageDialog(null, "File has been zipped at C:\\Users\\aelay\\Desktop\\data.zip");
							in.close();
							zipos.closeEntry();
							zipos.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, "Save the History File before Zipping.");
						}
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "File Not Found. Save the History File before Zipping.");
					}
				}
			});
			btnNewButton.setBounds(449, 57, 113, 25);
			contentPane.add(btnNewButton);
			
			btnGzipFile = new JButton("GZIP File");
			btnGzipFile.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						file_input = new FileInputStream("C:\\Users\\aelay\\Desktop\\data.txt");
						file_output = new FileOutputStream("C:\\Users\\aelay\\Desktop\\data.gz");
						GZIPOutputStream gzip_output = new GZIPOutputStream(file_output);
						copy(file_input,gzip_output);
						JOptionPane.showMessageDialog(null, "File has been Gzipped at C:\\Users\\aelay\\Desktop\\data.gz");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "File Not Found. Save the History File before Zipping.");
					}
				}

			});
			btnGzipFile.setBounds(449, 83, 113, 25);
			contentPane.add(btnGzipFile);
			
			btnUnzipFile = new JButton("UNZIP File");
			btnUnzipFile.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
					file_input_unzip = new FileInputStream(filename);
					zip = new ZipInputStream(new BufferedInputStream(file_input_unzip));
					while((entry= zip.getNextEntry()) !=null){
						
						try{
							byte[] bt = new byte[4*1024];
							String opfilepath = "C:\\Users\\aelay\\Desktop\\"+entry.getName();
							System.out.println("Extracting file to "+opfilepath);
							file_output_unzip = new FileOutputStream(opfilepath);
							int size=0;
							while((size = zip.read(bt)) != -1){
								file_output_unzip.write(bt,0,size);
							}
							file_output_unzip.flush();
							file_output_unzip.close();
							JOptionPane.showMessageDialog(null, "File has been unzipped at C:\\Users\\aelay\\Desktop\\ ");
						}
						catch(Exception e4){
							JOptionPane.showMessageDialog(null, "Upload the correct File.");
						}
					}
					zip.close();
					
					
					
					}
					catch(Exception e3){
						JOptionPane.showMessageDialog(null, "Upload the correct File.");
					}
					
				}
			});
			btnUnzipFile.setBounds(449, 108, 113, 25);
			contentPane.add(btnUnzipFile);
			
			btnUngzipFile = new JButton("UNGZIP File");
			btnUngzipFile.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
					FileInputStream file_input_gzip = new FileInputStream("C:\\Users\\aelay\\Desktop\\data.gz");
					GZIPInputStream gzip_input = new GZIPInputStream(file_input_gzip);
					FileOutputStream file_output_gzip = new FileOutputStream("C:\\Users\\aelay\\Desktop\\data_uncompressed.txt");
					copy(gzip_input, file_output_gzip);
					JOptionPane.showMessageDialog(null, "File has been Unzipped.");
					}
					catch(Exception e2){
						e2.printStackTrace();
					}
				}
			});
			btnUngzipFile.setBounds(449, 135, 113, 25);
			contentPane.add(btnUngzipFile);
			
			btnUploadFile = new JButton("Upload File");
			btnUploadFile.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
					JFileChooser chooser = new JFileChooser();
					chooser.showOpenDialog(null);
					File f= chooser.getSelectedFile();
					filename = f.getAbsolutePath();
					}
					catch(Exception exce){
						JOptionPane.showMessageDialog(null, "Error! Upload the File.");
					}
				}
			});
			btnUploadFile.setBounds(449, 31, 113, 25);
			contentPane.add(btnUploadFile);
			
			btnSelectDefault = new JButton("Select Default Directory");
			btnSelectDefault.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFileChooser chooser1 = new JFileChooser();
					chooser1.showOpenDialog(null);
					File f2= chooser1.getCurrentDirectory();
					directory = f2.getAbsolutePath();
					JOptionPane.showMessageDialog(null, "Default directory has been set.");
					label1 = new JLabel("");
					label1.setBounds(176, 336, 366, 16);
					contentPane.add(label1);
					label1.setForeground(Color.white);
					label1.setText("Path: "+directory+"\\data.txt");
					
				}
			});
			btnSelectDefault.setBounds(0, 330, 167, 28);
			contentPane.add(btnSelectDefault);
			pst.close();
			
			
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Select default directory.");
		}
		this.setVisible(true);
	}
	public void copy(InputStream file_input, OutputStream gzip_output) throws Exception {
		// TODO Auto-generated method stub
		int content = 0;
		while((content = file_input.read()) != -1){
			gzip_output.write(content);
		}
		gzip_output.close();
		file_input.close();
		
	}
}

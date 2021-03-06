package edu.esprit.gui.agent;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.esprit.delegater.GestionCareerObjectiveServiceDelegater;
import edu.esprit.domain.Agent;
import edu.esprit.domain.CareerObjectiveService;
import edu.esprit.domain.Employee;
import edu.esprit.gui.authentification.Authentification;
import gui.agent.service.MainService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.Color;

public class CareerObjectifServiceRequest extends JFrame {

	private JPanel contentPane;
    static Employee employee; 
    static int idService ;
    CareerObjectiveService career;
    TreatCareerObjReq treatcaree;
    JLabel reqDateText;
    private JLabel b3labeel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CareerObjectifServiceRequest frame = new CareerObjectifServiceRequest(employee ,idService);
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
	public CareerObjectifServiceRequest(Employee e , int id ) {
		employee=e ;
		idService=id;

		List<CareerObjectiveService> careerList = GestionCareerObjectiveServiceDelegater.doFindAllCareerObjectiveService();
		for(CareerObjectiveService cobj: careerList){
			if(cobj.getIdCareer()==idService)
				career=cobj;
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 909, 632);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel homeMenu = new JLabel("");
		homeMenu.setBounds(291, 47, 80, 37);
		homeMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HomeAgent homeAgent=new HomeAgent(employee);
			    setVisible(false);
			    homeAgent.setVisible(true);
			}
		});
		contentPane.add(homeMenu);
		
		JLabel servicesMenu = new JLabel("");
		servicesMenu.setBounds(374, 47, 80, 37);
		servicesMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainService mainService=new MainService(employee);
				setVisible(false);
				mainService.setVisible(true);
			}
		});
		contentPane.add(servicesMenu);
		
		JLabel statisticMenu = new JLabel("");
		statisticMenu.setBounds(461, 47, 72, 37);
		statisticMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StatisticAgent statAgent =new StatisticAgent(employee);
				setVisible(false);
				statAgent.setVisible(true);
				
			}
		});
		contentPane.add(statisticMenu);
		
		JLabel serviceReqMenu = new JLabel("");
		serviceReqMenu.setBounds(543, 46, 152, 38);
		serviceReqMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TreatBirthReg treatBR =new TreatBirthReg(employee);
				setVisible(false);
				treatBR.setVisible(true);
				
			}
		});
		contentPane.add(serviceReqMenu);
		
		JLabel claimMenu = new JLabel("");
		claimMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ManageClaim mClaim=new ManageClaim();
				hide();
				mClaim.show();
			
			}
		});
		claimMenu.setBounds(699, 47, 80, 37);
		contentPane.add(claimMenu);
		
		
		JLabel birthLabel = new JLabel("");
		birthLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TreatBirthReg birthreg=new TreatBirthReg(employee );
				hide();
				birthreg.show();
				
			}
		});
		birthLabel.setBounds(21, 197, 114, 51);
		contentPane.add(birthLabel);
		
		JLabel cinLabel = new JLabel("");
		cinLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TreatCinReq cinreq =new TreatCinReq(employee);
				hide();
				cinreq.show();
				
			}
		});
		cinLabel.setBounds(21, 259, 114, 51);
		contentPane.add(cinLabel);
		
		JLabel universitiesLabel = new JLabel("");
		universitiesLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TreatUniversity univerReq=new TreatUniversity(employee);
				hide();
				univerReq.show();
			}
		});
		universitiesLabel.setBounds(21, 321, 114, 51);
		contentPane.add(universitiesLabel);
		
		JLabel roadLabel = new JLabel("");
		roadLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TreatRoadReq roadReq=new TreatRoadReq(employee);
				hide();
				roadReq.show();
			}
		});
		roadLabel.setBounds(21, 383, 114, 51);
		contentPane.add(roadLabel);
		
		JLabel careerLabel = new JLabel("");
		careerLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TreatCareerObjReq careerReq =new TreatCareerObjReq(employee);
				hide();
				careerReq.show();
			}
		});
		careerLabel.setBounds(21, 445, 114, 51);
		contentPane.add(careerLabel);
		
		
		
		JLabel Birthcertificate = new JLabel("");
		Birthcertificate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)  {
				
				byte[] bAvatar = career.getBirthcertificate();
				int i=1;
				String namefile="";
				try{
					 namefile="C:/temp/birthReg"+i+".jpg";
				    FileOutputStream fos = new FileOutputStream(namefile); 
				    fos.write(bAvatar);
				    fos.close();
				    i++;
				}catch(Exception e1){
				    e1.printStackTrace();
				}
				
		        JOptionPane.showMessageDialog(contentPane, "the file is download you will find it in"+namefile);
				
			}
		});
		

        Birthcertificate.setBounds(553, 212, 48, 35);
	    contentPane.add(Birthcertificate);
	    
	    
	   
	    b3labeel = new JLabel("");
		b3labeel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)  {
				
				byte[] bAvatar = career.getBirthcertificate();
				int i=1;
				String namefile="";
				try{
					 namefile="C:/temp/birthReg"+i+".jpg";
				    FileOutputStream fos = new FileOutputStream(namefile); 
				    fos.write(bAvatar);
				    fos.close();
				    i++;
				}catch(Exception e1){
				    e1.printStackTrace();
				}
				
		        JOptionPane.showMessageDialog(contentPane, "the file is download you will find it in"+namefile);
				
			}
		});
		

        b3labeel.setBounds(706, 212, 48, 35);
	    contentPane.add(b3labeel);
	    
		
		
		
		
		
		
		
		
		JTextArea responsetext = new JTextArea();
		responsetext.setBounds(207, 396, 506, 168);
		
		contentPane.add(responsetext);
		
		JTextArea giroText = new JTextArea();
		giroText.setEditable(false);
		giroText.setBounds(539, 275, 167, 28);
		giroText.setText(career.getGiroAccount());
		contentPane.add(giroText);
		
		JLabel treatlabel = new JLabel("");
		treatlabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				career.setRequestState("treated");
				career.setResponse(responsetext.getText());
				career.setResponseDate(new Date());
				Agent agent=(Agent) employee;
				career.setAgent(agent);
				GestionCareerObjectiveServiceDelegater.doUpdateCareerObjectiveService(career);
				treatcaree=new TreatCareerObjReq(employee);
				setVisible(false);
				treatcaree.setVisible(true);
			}
		});
		treatlabel.setBounds(751, 462, 92, 33);
		contentPane.add(treatlabel);
		
		reqDateText = new JLabel("New label");
		reqDateText.setBounds(767, 152, 87, 29);
		reqDateText.setForeground(Color.white);
		contentPane.add(reqDateText);
		
		JLabel deconnexionLabel = new JLabel("");
		deconnexionLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Authentification auth=new Authentification();
				setVisible(false);
				auth.setVisible(true);
			}
		});
		deconnexionLabel.setBounds(857, 11, 36, 36);
		contentPane.add(deconnexionLabel);
		
		
		JLabel imagelabel = new JLabel("");
		imagelabel.setIcon(new ImageIcon(CareerObjectifServiceRequest.class.getResource("/edu/esprit/image/CareerObjective1.jpg")));
		imagelabel.setBounds(0, -17, 909, 632);
		contentPane.add(imagelabel);
		
		JLabel birthCertText = new JLabel("");
		birthCertText.setBounds(560, 212, 28, 22);
		contentPane.add(birthCertText);
		
		JLabel b3label = new JLabel("");
		b3label.setBounds(710, 212, 28, 22);
		contentPane.add(b3label);
		
		JLabel cinlabel = new JLabel("");
		cinlabel.setBounds(276, 212, 22, 22);
		contentPane.add(cinlabel);
	}

}

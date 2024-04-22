package LoginTest;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Login {
	private InfoDAO dao;
	ArrayList<InfoVo> list;
	
	public Login() {
		dao = new InfoDAO();
		Frame f = new Frame("Login");
		f.setSize(400, 200);
		f.setLayout(null);

		Label lid = new Label("ID : ", Label.RIGHT);
		Label lpwd = new Label("Password : ", Label.RIGHT);

		lid.setSize(80, 40);
		lid.setLocation(10, 50);

		lpwd.setSize(80, 40);
		lpwd.setLocation(10, 100);

		TextField id = new TextField(10);
		TextField pwd = new TextField(10);
		pwd.setEchoChar('*');

		id.setSize(250, 20);
		id.setLocation(100, 60);

		pwd.setSize(250, 20);
		pwd.setLocation(100, 110);

		Button b = new Button("login");

		b.setSize(100, 30);
		b.setLocation(160, 140);
		b.addActionListener(new ActionListener() { // 버튼 액션 리스너

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(id.getText() + " : " + pwd.getText());
				String fid = id.getText();

				list = dao.list(fid);
				
				if (list.size() != 0) {
					for (int i = 0; i < list.size(); i++) {
						InfoVo data = (InfoVo) list.get(i);
						String gid = data.getId();
						String gpwd = data.getPwd();

						System.out.println(gid + " :: " + gpwd);

						if (id.getText().equals(gid) && pwd.getText().equals(gpwd)) {
							System.out.println("로그인이 성공했습니다.");
						} else {
							System.out.println("로그인이 실패했습니다.");
						}
					}
				} else {
					System.out.println("로그인이 실패했습니다.");
				}

				for (int i = 0; i < list.size(); i++) {
					InfoVo data = (InfoVo) list.get(i);
					String gid = data.getId();
					String gpwd = data.getPwd();

					System.out.println(gid + " :: " + gpwd);
				}

			}
		});

		f.add(lid);
		f.add(id);

		f.add(lpwd);
		f.add(pwd);
		f.add(b);
		f.setVisible(true);
	}
		public static void main(String[] args) {
			new Login();
			
		}
	}
	



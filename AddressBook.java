import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
 
public class AddressBook extends JFrame implements ActionListener{ //implements ActionListener{
   
  //..............Buttons...................
   
  JButton sortButton = new JButton("Sort");
  JButton saveButton = new JButton("Save");
  JButton editButton = new JButton("Edit");
  JButton deleteButton = new JButton("Delete");
  JButton searchButton = new JButton("Search");
  JButton backButton = new JButton("<<");
  JButton forwardButton = new JButton(">>");
  JButton clearButton = new JButton("Clear");
  JButton exitButton = new JButton("Exit");
   
   
   
  //...............Labels...................
   
  JLabel searchLabel = new JLabel("Search name: ");
  JLabel nameLabel = new JLabel("Name: ");
  JLabel addressLabel = new JLabel("Address: ");
  JLabel phoneLabel= new JLabel("Phone: ");
  JLabel emailLabel = new JLabel("Email: ");
  JLabel deleteLabel = new JLabel("Delete name: ");
  JLabel interactLabel = new JLabel(" Welcome to your address book!");
   
  //..............Text Field...............
   
  JTextField searchField = new JTextField(20);
  JTextField nameField = new JTextField(20);
  JTextField addressField = new JTextField(20);
  JTextField phoneField = new JTextField(20);
  JTextField emailField = new JTextField(20);
  JTextField deleteField = new JTextField(20);
   
  //................Panels.................
   
  JPanel panel1 = new JPanel();
  JPanel panel2 = new JPanel();
  JPanel panel3 = new JPanel();
  JPanel panel4 = new JPanel();
  JPanel panel5 = new JPanel();
  JPanel panel6 = new JPanel();
   
   
  //................Design.................
   
  BoxLayout Layout1 = new BoxLayout(panel1, BoxLayout.Y_AXIS);
  FlowLayout Layout = new FlowLayout();
   
  //...............Arrays..................
   
  String name[] = new String[100];
  String last[] = new String[100];
  String address[] = new String[100];
  String email[] = new String[100];
  String phone[] = new String[100];
   
  //..............Variables................
   
  int count = 0;
  int rightcount;
  int swap;
  String temp;
  int duplicate = 0;
   
  //............Gui Constructer............
   
   
  public AddressBook(){
     
    setTitle("Address Book");
    setSize(350,400);
     
    setLayout(Layout);
     
    panel1.setLayout(Layout1);
     
    panel1.add(nameLabel);
    panel1.add(nameField);
     
     
    panel1.add(phoneLabel);
    panel1.add(phoneField);
     
    panel1.add(addressLabel);
    panel1.add(addressField);
     
     
    panel1.add(emailLabel);
    panel1.add(emailField);
     
    add(panel1);
     
     
    panel2.setLayout(Layout);
     
    backButton.addActionListener(this);
    panel2.add(backButton);
     
    saveButton.addActionListener(this);
    panel2.add(saveButton);
     
    editButton.addActionListener(this);
    panel2.add(editButton);
     
    forwardButton.addActionListener(this);
    panel2.add(forwardButton);
     
    add(panel2);
     
    panel3.setLayout(Layout);
     
    panel3.add(searchLabel);
    panel3.add(searchField);
     
    searchButton.addActionListener(this);
    panel3.add(searchButton);
     
    add(panel3);
     
    panel4.setLayout(Layout);
     
    panel4.add(deleteLabel);
    panel4.add(deleteField);
     
    deleteButton.addActionListener(this);
    panel4.add(deleteButton);
     
    add(panel4);
     
    panel5.setLayout(Layout);
    
    clearButton.addActionListener(this);
    panel5.add(clearButton);
    
    sortButton.addActionListener(this);
    panel5.add(sortButton);
    
    exitButton.addActionListener(this);
    panel5.add(exitButton);
    
    add(panel5);
    
    panel6.setPreferredSize(new Dimension(350,100));
    panel6.setLayout(Layout);
    panel6.add(interactLabel);
     
    add(panel6);
     
    setVisible(true);
    setResizable(false);
     
    for(int count = 0; count < 100; count++){
      name[count] = " ";
      phone[count] = " ";
      address[count] = " ";
      email[count] = " ";
       
    }
  }
   
   
  //..........ActionCommand Code.........
   
  public void actionPerformed(ActionEvent event) {
    String command = event.getActionCommand();
     
    interactLabel.setText("");
    
    
    if(command.equals("Save") && name[count] == " " && phone[count] == " " && address[count] == " " && email[count] == " "){
      
      for(count=0;count<rightcount;count++){
        if( nameField.getText().trim().equals(name[count]) && phoneField.getText().trim().equals(phone[count]) && addressField.getText().trim().equals(address[count]) && emailField.getText().trim().equals(email[count]) ){
          duplicate = 1;
        }else{
          duplicate = 2;
        }
      }
      
      if(duplicate == 1){
        nameField.setText("");
        phoneField.setText("");
        addressField.setText("");
        emailField.setText(""); 
        duplicate = 2;
        interactLabel.setText("Duplicate Contact. Enter new contact.");
      }
      
      else if(phoneField.getText().trim().length() != 10){
        phoneField.setText("");
        interactLabel.setText("Enter a valid phone number");
      }
      else if(emailField.getText().trim().indexOf("@") == -1 || emailField.getText().trim().indexOf("@") == 0){
        interactLabel.setText("Enter a valid email address");
        emailField.setText("");
      }
      else if(nameField.getText().equals("")){
        interactLabel.setText("Fill out name");
      nameField.setText("");
    }
        
      else if (addressField.getText().equals("")){
        interactLabel.setText("Fill out address");
        addressField.setText("");
      }
      else{
        name[count] = nameField.getText();
        phone[count] = phoneField.getText();
        address[count] = addressField.getText();
        email[count] = emailField.getText();
         
        nameField.setText("");
        phoneField.setText("");
        addressField.setText("");
        emailField.setText(""); 
        interactLabel.setText("The contact has been saved");
         
        last[count] = name[count].substring (name[count].indexOf(" ")+1 , name[count].length());
        System.out.println(last[count]);
        count ++;
        rightcount = count;
      }
    }
    else if(command.equals("Search")){
      for(int count = 0; count < 100; count ++){
        if(searchField.getText().equals(name[count])){
          nameField.setText(name[count]);
          phoneField.setText(phone[count]);
          addressField.setText(address[count]);
          emailField.setText(email[count]);
          searchField.setText("");
          interactLabel.setText(name[count]);
          rightcount = count;
        }
      }
    }
    else if(command.equals("Delete")){
      for(int count = 0; count < 100; count ++){
        if(deleteField.getText().equals(name[count])){
          name[count] = " ";
          phone[count] = " ";
          address[count] = " ";
          email[count] = " ";
          deleteField.setText("");
          interactLabel.setText("This person has been deleted");
        }
      }
    }
    else if(command.equals("Edit")){
      for(count = 0; count<100; count++){
        name[count] = nameField.getText();
        phone[count] = phoneField.getText();
        address[count] = addressField.getText();
        email[count] = emailField.getText();
        System.out.print(name[count] + phone[count] + address[count] + email[count]); 
         
        nameField.setText("");
        phoneField.setText("");
        addressField.setText("");
        emailField.setText(""); 
        interactLabel.setText("This person has been edited");
      }
    }
    else if(command.equals("<<")){
      if(rightcount>0){
        rightcount --;
        nameField.setText(name[rightcount]);
        phoneField.setText(phone[rightcount]);
        addressField.setText(address[rightcount]);
        emailField.setText(email[rightcount]);
         
      }
    }
    else if(command.equals(">>")){
      if(rightcount < count){
        rightcount++;
        nameField.setText(name[rightcount]);
        phoneField.setText(phone[rightcount]);
        addressField.setText(address[rightcount]);
        emailField.setText(email[rightcount]);
      }
    }
    else if(command.equals("Clear")){
      nameField.setText("");
      phoneField.setText("");
      addressField.setText("");
      emailField.setText(""); 
    }
    else if(command.equals("Sort")){
      for(count=0; count<rightcount;count++){
        for(int num=0; num< rightcount - 1; num++){
          if( last[num].compareTo(last[num+1]) > 0){
            temp = last[num];
            last[num] = last[num+1];
            last[num+1] = temp;
             
            temp = name[num];
            name[num] = name[num+1];
            name[num+1] = temp;
             
            temp = phone[num];
            phone[num] = phone[num+1];
            phone[num+1] = temp;
               
            temp = address[num];
           address[num] = address[num+1];
            address[num+1] = temp;
             
            temp = email[num];
            email[num] = email[num+1];
            email[num+1] = temp;
            swap++;
    }  
           if(command.equals("<<")){
      if(rightcount>0){
        rightcount --;
        nameField.setText(name[num]);
        phoneField.setText(phone[num]);
        addressField.setText(address[num]);
        emailField.setText(email[num]);
         
      }
    }
          else if(command.equals(">>")){
      if(rightcount < count){
        rightcount++;
        nameField.setText(name[num]);
        phoneField.setText(phone[num]);
        addressField.setText(address[num]);
        emailField.setText(email[num]);
      }
        }
        }
        if(swap==0){
          break;
        } 
        
      }
     interactLabel.setText("You can now view your contacts in alphabetical order using the arrows."); 
    }
    else if(command.equals("Exit")){
      System.exit(0);
    }
  }
   
  public static void main(String[] args) throws Exception { 
    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    AddressBook frame = new AddressBook();
     
  }
}
 
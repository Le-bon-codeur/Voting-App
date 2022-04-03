package votingapp3.view;

import javax.swing.JOptionPane;
import votingapp3.controller.AdminController;
import votingapp3.model.Admin;
import votingapp3.model.Citizen;

public class AdministratorView extends javax.swing.JFrame {

    private final AdminController controller;
    private Citizen citizen;

    /**
     * Creates new form AdministratorView
     * @param admin
     */
    public AdministratorView(Admin admin) {
        super("Administration Vote'it");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
        this.setResizable(false);

        this.controller = new AdminController(admin);
        this.citizen = null;
    }
    
    private void updateCitizenProfile() {
        jTextFieldUserProfileBirthday.setText(citizen.getDob().toString());
        jTextFieldUserProfileFname.setText(citizen.getFname());
        jTextFieldUserProfileLname.setText(citizen.getLname());
        jTextFieldUserProfileLocation.setText(citizen.getLocation());
        if("g".equals(citizen.getGender()) || "f".equals(citizen.getGender()))
            jTextFieldUserProfileGender.setText("Female");
        else
            jTextFieldUserProfileGender.setText("Male");
    }
    
    private void resetCreationForm() {
        jTextFieldCreateLocation.setText("Location");
        jTextFieldCreateBirthday.setText("Birthdate");
        jTextFieldCreateFname.setText("Firstname");
        jTextFieldCreateLname.setText("Lastname");
        jTextFieldCreateId.setText("User ID");
        jRadioButtonCreateFemale.setSelected(false);
        jRadioButtonCreateMale.setSelected(false);
    }
    
    private void resetCitizenProfile() {
        jTextFieldUserProfileBirthday.setText("1999-01-01");
        jTextFieldUserProfileFname.setText("John");
        jTextFieldUserProfileLname.setText("Dupont");
        jTextFieldUserProfileLocation.setText("Nice");
        jTextFieldUserProfileGender.setText("Male");
        jTextFieldSerachName.setText("User ID");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        buttonGroup1 = new javax.swing.ButtonGroup();
        MainPanel = new javax.swing.JPanel();
        MenuPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldCreateLname = new javax.swing.JTextField();
        jTextFieldCreateFname = new javax.swing.JTextField();
        jTextFieldCreateLocation = new javax.swing.JTextField();
        jTextFieldCreateBirthday = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jRadioButtonCreateMale = new javax.swing.JRadioButton();
        jRadioButtonCreateFemale = new javax.swing.JRadioButton();
        jButtonCreate = new javax.swing.JButton();
        jTextFieldCreateId = new javax.swing.JTextField();
        jPanelProfile = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldUserProfileLname = new javax.swing.JTextField();
        jTextFieldUserProfileGender = new javax.swing.JTextField();
        jTextFieldUserProfileBirthday = new javax.swing.JTextField();
        jTextFieldUserProfileLocation = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldUserProfileFname = new javax.swing.JTextField();
        jButtonUpdate = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jTextFieldSerachName = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();
        jButtonDisconnect = new javax.swing.JButton();

        jLabel8.setBackground(new java.awt.Color(0, 102, 102));
        jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Name :");

        jLabel10.setBackground(new java.awt.Color(0, 102, 102));
        jLabel10.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Name :");

        jTextField7.setBackground(new java.awt.Color(0, 102, 102));
        jTextField7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(255, 255, 255));
        jTextField7.setText("Maurille");
        jTextField7.setBorder(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MainPanel.setBackground(new java.awt.Color(0, 102, 102));

        MenuPanel.setBackground(new java.awt.Color(0, 51, 51));

        jLabel1.setBackground(new java.awt.Color(0, 51, 51));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("VOTE'IT");

        jLabel2.setBackground(new java.awt.Color(0, 51, 51));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("administrator window");

        jTextFieldCreateLname.setBackground(new java.awt.Color(0, 51, 51));
        jTextFieldCreateLname.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTextFieldCreateLname.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldCreateLname.setText("Lastname");
        jTextFieldCreateLname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jTextFieldCreateLname.setPreferredSize(new java.awt.Dimension(180, 35));
        jTextFieldCreateLname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCreateLnameActionPerformed(evt);
            }
        });

        jTextFieldCreateFname.setBackground(new java.awt.Color(0, 51, 51));
        jTextFieldCreateFname.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTextFieldCreateFname.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldCreateFname.setText("Firstname");
        jTextFieldCreateFname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jTextFieldCreateFname.setPreferredSize(new java.awt.Dimension(180, 35));

        jTextFieldCreateLocation.setBackground(new java.awt.Color(0, 51, 51));
        jTextFieldCreateLocation.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTextFieldCreateLocation.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldCreateLocation.setText("Location");
        jTextFieldCreateLocation.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jTextFieldCreateLocation.setPreferredSize(new java.awt.Dimension(180, 35));

        jTextFieldCreateBirthday.setBackground(new java.awt.Color(0, 51, 51));
        jTextFieldCreateBirthday.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTextFieldCreateBirthday.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldCreateBirthday.setText("Birthdate");
        jTextFieldCreateBirthday.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jTextFieldCreateBirthday.setPreferredSize(new java.awt.Dimension(180, 35));

        jLabel3.setBackground(new java.awt.Color(0, 51, 51));
        jLabel3.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("format: YYYY-MM-DD");

        jRadioButtonCreateMale.setBackground(new java.awt.Color(0, 51, 51));
        buttonGroup1.add(jRadioButtonCreateMale);
        jRadioButtonCreateMale.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jRadioButtonCreateMale.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonCreateMale.setText("Male");
        jRadioButtonCreateMale.setFocusPainted(false);

        jRadioButtonCreateFemale.setBackground(new java.awt.Color(0, 51, 51));
        buttonGroup1.add(jRadioButtonCreateFemale);
        jRadioButtonCreateFemale.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jRadioButtonCreateFemale.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonCreateFemale.setText("Female");
        jRadioButtonCreateFemale.setFocusPainted(false);

        jButtonCreate.setBackground(new java.awt.Color(0, 51, 51));
        jButtonCreate.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButtonCreate.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCreate.setText("Create");
        jButtonCreate.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        jButtonCreate.setFocusPainted(false);
        jButtonCreate.setPreferredSize(new java.awt.Dimension(130, 35));
        jButtonCreate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCreateMouseClicked(evt);
            }
        });

        jTextFieldCreateId.setBackground(new java.awt.Color(0, 51, 51));
        jTextFieldCreateId.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTextFieldCreateId.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldCreateId.setText("User ID");
        jTextFieldCreateId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jTextFieldCreateId.setPreferredSize(new java.awt.Dimension(180, 35));
        jTextFieldCreateId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCreateIdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MenuPanelLayout = new javax.swing.GroupLayout(MenuPanel);
        MenuPanel.setLayout(MenuPanelLayout);
        MenuPanelLayout.setHorizontalGroup(
            MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuPanelLayout.createSequentialGroup()
                        .addGap(0, 131, Short.MAX_VALUE)
                        .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldCreateBirthday, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldCreateLocation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldCreateFname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldCreateLname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldCreateId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(133, 133, 133))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(MenuPanelLayout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(jRadioButtonCreateMale)
                .addGap(18, 18, 18)
                .addComponent(jRadioButtonCreateFemale)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        MenuPanelLayout.setVerticalGroup(
            MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(84, 84, 84)
                .addComponent(jTextFieldCreateId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jTextFieldCreateLname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jTextFieldCreateFname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jTextFieldCreateLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jTextFieldCreateBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(36, 36, 36)
                .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonCreateMale)
                    .addComponent(jRadioButtonCreateFemale))
                .addGap(53, 53, 53)
                .addComponent(jButtonCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelProfile.setBackground(new java.awt.Color(0, 102, 102));
        jPanelProfile.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(204, 204, 204)));
        jPanelProfile.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setBackground(new java.awt.Color(0, 102, 102));
        jLabel5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("User Profile");

        jLabel4.setBackground(new java.awt.Color(0, 102, 102));
        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("To update a profile, change the profile informations under");

        jLabel6.setBackground(new java.awt.Color(0, 102, 102));
        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("To save your edits just press the update button.");

        jLabel7.setBackground(new java.awt.Color(0, 102, 102));
        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Lname :");

        jLabel9.setBackground(new java.awt.Color(0, 102, 102));
        jLabel9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Gender :");

        jLabel11.setBackground(new java.awt.Color(0, 102, 102));
        jLabel11.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Birthdate :");

        jLabel12.setBackground(new java.awt.Color(0, 102, 102));
        jLabel12.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Location :");

        jTextFieldUserProfileLname.setBackground(new java.awt.Color(0, 102, 102));
        jTextFieldUserProfileLname.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTextFieldUserProfileLname.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldUserProfileLname.setText("Dupont");
        jTextFieldUserProfileLname.setBorder(null);

        jTextFieldUserProfileGender.setBackground(new java.awt.Color(0, 102, 102));
        jTextFieldUserProfileGender.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTextFieldUserProfileGender.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldUserProfileGender.setText("Male");
        jTextFieldUserProfileGender.setBorder(null);

        jTextFieldUserProfileBirthday.setBackground(new java.awt.Color(0, 102, 102));
        jTextFieldUserProfileBirthday.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTextFieldUserProfileBirthday.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldUserProfileBirthday.setText("1999-01-01");
        jTextFieldUserProfileBirthday.setBorder(null);

        jTextFieldUserProfileLocation.setBackground(new java.awt.Color(0, 102, 102));
        jTextFieldUserProfileLocation.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTextFieldUserProfileLocation.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldUserProfileLocation.setText("Nice");
        jTextFieldUserProfileLocation.setBorder(null);

        jLabel13.setBackground(new java.awt.Color(0, 102, 102));
        jLabel13.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Fname :");

        jTextFieldUserProfileFname.setBackground(new java.awt.Color(0, 102, 102));
        jTextFieldUserProfileFname.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTextFieldUserProfileFname.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldUserProfileFname.setText("John");
        jTextFieldUserProfileFname.setBorder(null);
        jTextFieldUserProfileFname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUserProfileFnameActionPerformed(evt);
            }
        });

        jButtonUpdate.setBackground(new java.awt.Color(0, 102, 102));
        jButtonUpdate.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButtonUpdate.setForeground(new java.awt.Color(255, 255, 255));
        jButtonUpdate.setText("Update");
        jButtonUpdate.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        jButtonUpdate.setFocusPainted(false);
        jButtonUpdate.setPreferredSize(new java.awt.Dimension(130, 35));
        jButtonUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonUpdateMouseClicked(evt);
            }
        });

        jButtonDelete.setBackground(new java.awt.Color(0, 102, 102));
        jButtonDelete.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButtonDelete.setForeground(new java.awt.Color(255, 255, 255));
        jButtonDelete.setText("Delete");
        jButtonDelete.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        jButtonDelete.setFocusPainted(false);
        jButtonDelete.setPreferredSize(new java.awt.Dimension(130, 35));
        jButtonDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonDeleteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelProfileLayout = new javax.swing.GroupLayout(jPanelProfile);
        jPanelProfile.setLayout(jPanelProfileLayout);
        jPanelProfileLayout.setHorizontalGroup(
            jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProfileLayout.createSequentialGroup()
                .addGroup(jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelProfileLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanelProfileLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelProfileLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldUserProfileFname))
                            .addGroup(jPanelProfileLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldUserProfileLname, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelProfileLayout.createSequentialGroup()
                                .addGroup(jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelProfileLayout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldUserProfileBirthday))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelProfileLayout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextFieldUserProfileLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelProfileLayout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextFieldUserProfileGender, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(jPanelProfileLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelProfileLayout.setVerticalGroup(
            jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProfileLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(66, 66, 66)
                .addGroup(jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldUserProfileLname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextFieldUserProfileFname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldUserProfileGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextFieldUserProfileBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextFieldUserProfileLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );

        jTextFieldSerachName.setBackground(new java.awt.Color(0, 102, 102));
        jTextFieldSerachName.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jTextFieldSerachName.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldSerachName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldSerachName.setText("User ID");
        jTextFieldSerachName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jTextFieldSerachName.setPreferredSize(new java.awt.Dimension(130, 35));

        jButtonSearch.setBackground(new java.awt.Color(0, 102, 102));
        jButtonSearch.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButtonSearch.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSearch.setText("Search");
        jButtonSearch.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        jButtonSearch.setFocusPainted(false);
        jButtonSearch.setPreferredSize(new java.awt.Dimension(130, 35));
        jButtonSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSearchMouseClicked(evt);
            }
        });

        jButtonDisconnect.setBackground(new java.awt.Color(0, 51, 51));
        jButtonDisconnect.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonDisconnect.setForeground(new java.awt.Color(255, 255, 255));
        jButtonDisconnect.setText("Disconnect");
        jButtonDisconnect.setBorder(null);
        jButtonDisconnect.setFocusPainted(false);
        jButtonDisconnect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonDisconnectMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(MenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanelProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(MainPanelLayout.createSequentialGroup()
                                .addComponent(jTextFieldSerachName, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap(57, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonDisconnect, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jPanelProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldSerachName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jButtonDisconnect, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(960, 780));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldCreateLnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCreateLnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCreateLnameActionPerformed

    private void jButtonDisconnectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonDisconnectMouseClicked
        new EntryView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonDisconnectMouseClicked

    private void jTextFieldUserProfileFnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUserProfileFnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldUserProfileFnameActionPerformed

    private void jTextFieldCreateIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCreateIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCreateIdActionPerformed

    private void jButtonSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSearchMouseClicked
        try {
            this.citizen = controller.search(Integer.parseInt(jTextFieldSerachName.getText()));
            updateCitizenProfile();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_jButtonSearchMouseClicked

    private void jButtonUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonUpdateMouseClicked

        String args[] = {
            jTextFieldSerachName.getText(),
            jTextFieldUserProfileLname.getText(),
            jTextFieldUserProfileFname.getText(),
            jTextFieldUserProfileLocation.getText(),
            jTextFieldUserProfileBirthday.getText(),
            jTextFieldUserProfileGender.getText()
        };
        
        
        try {
            if(controller.update(this.citizen, args))
                JOptionPane.showMessageDialog(this, "Successfully updated for user " + citizen.getLname());
            else
                JOptionPane.showMessageDialog(this, "An error occured, please try again!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_jButtonUpdateMouseClicked

    private void jButtonDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonDeleteMouseClicked
        try {
            if(controller.delete(citizen)) {
                JOptionPane.showMessageDialog(this, "Successfully deleted.");
                resetCitizenProfile();
            } else
                JOptionPane.showMessageDialog(this, "An error occured, please trye again.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_jButtonDeleteMouseClicked

    private void jButtonCreateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCreateMouseClicked
        String gender;
        if(jRadioButtonCreateMale.isSelected())
            gender = "b";
        else if(jRadioButtonCreateFemale.isSelected())
            gender = "g";
        else
            gender = "n";
        String args[] = {
            jTextFieldCreateId.getText(),
            jTextFieldCreateLname.getText(),
            jTextFieldCreateFname.getText(),
            jTextFieldCreateLocation.getText(),
            jTextFieldCreateBirthday.getText(),
            gender
        };
        
        try {
            String returnVal = controller.create(args);
            if(returnVal != null) {
                JOptionPane.showMessageDialog(this, "Successfully created.\nThe new password is: " + returnVal);
                resetCreationForm();
            }
            else
                JOptionPane.showMessageDialog(this, "Problem during the creation, please try again!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_jButtonCreateMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainPanel;
    private javax.swing.JPanel MenuPanel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonCreate;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonDisconnect;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanelProfile;
    private javax.swing.JRadioButton jRadioButtonCreateFemale;
    private javax.swing.JRadioButton jRadioButtonCreateMale;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextFieldCreateBirthday;
    private javax.swing.JTextField jTextFieldCreateFname;
    private javax.swing.JTextField jTextFieldCreateId;
    private javax.swing.JTextField jTextFieldCreateLname;
    private javax.swing.JTextField jTextFieldCreateLocation;
    private javax.swing.JTextField jTextFieldSerachName;
    private javax.swing.JTextField jTextFieldUserProfileBirthday;
    private javax.swing.JTextField jTextFieldUserProfileFname;
    private javax.swing.JTextField jTextFieldUserProfileGender;
    private javax.swing.JTextField jTextFieldUserProfileLname;
    private javax.swing.JTextField jTextFieldUserProfileLocation;
    // End of variables declaration//GEN-END:variables
}

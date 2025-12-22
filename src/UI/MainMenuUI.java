package UI;

public class MainMenuUI extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MainMenuUI.class.getName());

    public MainMenuUI() {
        initComponents();

        GeriDonBtn.setIcon(UI.IconHelper.createIcon("/resources/back.png", 32, 32));
        GeriDonBtn.setContentAreaFilled(false); // Arka plan rengini kapat
        GeriDonBtn.setBorderPainted(false);     // Çerçeve çizgisini kapat
        GeriDonBtn.setFocusPainted(false);      // Tıklanınca çıkan odak çizgisini kapat
        GeriDonBtn.setVisible(false);
        //Açılışta Tarihi Yaz
        tarihiGuncelle();

        //OTOMATİK GÜNCELLEME
        // Her 1 saniyede bir tarihi kontrol eder, konsoldan değiştiyse günceller.
        javax.swing.Timer timer = new javax.swing.Timer(1000, new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                tarihiGuncelle();
            }
        });
        timer.start();
        bilesenBoyutlariniSabitle();
        sifreGosterGizleAyarlari();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        AnaMenuKullaniciTipiRDB = new javax.swing.ButtonGroup();
        BireyselGirisTipiRDB = new javax.swing.ButtonGroup();
        jSeparator2 = new javax.swing.JSeparator();
        MainPanel = new javax.swing.JPanel();
        UstPanel = new javax.swing.JPanel();
        BankaAdiLabel = new javax.swing.JLabel();
        AdminControlsBtn = new javax.swing.JButton();
        TarihveSaatLabel = new javax.swing.JLabel();
        PanelContainer = new javax.swing.JPanel();
        FirstPanel = new javax.swing.JPanel();
        BireyselRadioBtn = new javax.swing.JRadioButton();
        KurumsalRadioBtn = new javax.swing.JRadioButton();
        GirisYapBtn = new javax.swing.JButton();
        HesapOlusturBtn = new javax.swing.JButton();
        BireyselGirisYapPanel = new javax.swing.JPanel();
        BireyselGirisTamamlaBtn = new javax.swing.JButton();
        TCGirisRadioBtn = new javax.swing.JRadioButton();
        MusteriNoGirisRadioBtn = new javax.swing.JRadioButton();
        TelNoGirisRadioBtn = new javax.swing.JRadioButton();
        BireyselTypeGirisTextF = new javax.swing.JTextField();
        BireyselSifreGirisPasswordTF = new javax.swing.JPasswordField();
        BireyselGirisSifreGoster = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        KurumsalGirisPanel = new javax.swing.JPanel();
        KurumsalGirisTamamlaBtn = new javax.swing.JButton();
        KurumKoduGirisTextF = new javax.swing.JTextField();
        KurumsalSifreGirisPasswordTF = new javax.swing.JPasswordField();
        KurumsalGirisSifreGoster = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        BireyselKayitPanel = new javax.swing.JPanel();
        BireyselKayıtTamamlaBtn = new javax.swing.JButton();
        BireyselAdGirisTextF = new javax.swing.JTextField();
        BireyselSoyadGirisTextF = new javax.swing.JTextField();
        BireyselTcGirisFormattedTextF = new javax.swing.JFormattedTextField();
        BireyselDogumTGirisFormattedTextF = new javax.swing.JFormattedTextField();
        BireyselSehirGirisTextF = new javax.swing.JTextField();
        BireyselTelefonGirisTextF = new javax.swing.JFormattedTextField();
        BireyselSifreKayitPasswordTF = new javax.swing.JPasswordField();
        BireyselKayitSifreGoster = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        KurumsalKayitPanel = new javax.swing.JPanel();
        KurumsalKayıtTamamlaBtn = new javax.swing.JButton();
        KurumsalAdGirisTextF = new javax.swing.JTextField();
        KurumsalTarihGirisFormattedTF = new javax.swing.JFormattedTextField();
        KurumsalSehirGirisTextF = new javax.swing.JTextField();
        KurumsalSifreKayitPasswordTF = new javax.swing.JPasswordField();
        KurumsalKayitSifreGoster = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        GeriDonBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        UstPanel.setBackground(new java.awt.Color(0, 102, 153));

        BankaAdiLabel.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        BankaAdiLabel.setText("DİNO BANK");

        AdminControlsBtn.setBackground(new java.awt.Color(102, 0, 0));
        AdminControlsBtn.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        AdminControlsBtn.setText("AdminControls");
        AdminControlsBtn.addActionListener(this::AdminControlsBtnActionPerformed);

        TarihveSaatLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        TarihveSaatLabel.setText("Tarih ve Saat");

        javax.swing.GroupLayout UstPanelLayout = new javax.swing.GroupLayout(UstPanel);
        UstPanel.setLayout(UstPanelLayout);
        UstPanelLayout.setHorizontalGroup(
                UstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UstPanelLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(TarihveSaatLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 356, Short.MAX_VALUE)
                                .addComponent(BankaAdiLabel)
                                .addGap(310, 310, 310)
                                .addComponent(AdminControlsBtn)
                                .addGap(16, 16, 16))
        );
        UstPanelLayout.setVerticalGroup(
                UstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(UstPanelLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(UstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(BankaAdiLabel)
                                        .addComponent(AdminControlsBtn)
                                        .addComponent(TarihveSaatLabel))
                                .addContainerGap(25, Short.MAX_VALUE))
        );

        PanelContainer.setMinimumSize(new java.awt.Dimension(600, 350));
        PanelContainer.setPreferredSize(new java.awt.Dimension(600, 350));
        PanelContainer.setLayout(new java.awt.CardLayout());

        AnaMenuKullaniciTipiRDB.add(BireyselRadioBtn);
        BireyselRadioBtn.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        BireyselRadioBtn.setText("Bireysel");

        AnaMenuKullaniciTipiRDB.add(KurumsalRadioBtn);
        KurumsalRadioBtn.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        KurumsalRadioBtn.setText("Kurumsal");

        GirisYapBtn.setBackground(new java.awt.Color(0, 102, 153));
        GirisYapBtn.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        GirisYapBtn.setText("Giriş Yap");
        GirisYapBtn.addActionListener(this::GirisYapBtnActionPerformed);

        HesapOlusturBtn.setBackground(new java.awt.Color(0, 102, 153));
        HesapOlusturBtn.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        HesapOlusturBtn.setText("Hesap Oluştur");
        HesapOlusturBtn.addActionListener(this::HesapOlusturBtnActionPerformed);

        javax.swing.GroupLayout FirstPanelLayout = new javax.swing.GroupLayout(FirstPanel);
        FirstPanel.setLayout(FirstPanelLayout);
        FirstPanelLayout.setHorizontalGroup(
                FirstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(FirstPanelLayout.createSequentialGroup()
                                .addGap(376, 376, 376)
                                .addGroup(FirstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                        .addGroup(FirstPanelLayout.createSequentialGroup()
                                                .addComponent(BireyselRadioBtn)
                                                .addGap(63, 63, 63)
                                                .addComponent(KurumsalRadioBtn))
                                        .addComponent(GirisYapBtn)
                                        .addComponent(HesapOlusturBtn))
                                .addContainerGap(342, Short.MAX_VALUE))
        );
        FirstPanelLayout.setVerticalGroup(
                FirstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(FirstPanelLayout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addGroup(FirstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(BireyselRadioBtn)
                                        .addComponent(KurumsalRadioBtn))
                                .addGap(48, 48, 48)
                                .addComponent(GirisYapBtn)
                                .addGap(31, 31, 31)
                                .addComponent(HesapOlusturBtn)
                                .addContainerGap(186, Short.MAX_VALUE))
        );

        PanelContainer.add(FirstPanel, "cardFirstPanel");

        BireyselGirisTamamlaBtn.setBackground(new java.awt.Color(0, 102, 102));
        BireyselGirisTamamlaBtn.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        BireyselGirisTamamlaBtn.setText("Giriş Yap");
        BireyselGirisTamamlaBtn.addActionListener(this::BireyselGirisTamamlaBtnActionPerformed);

        BireyselGirisTipiRDB.add(TCGirisRadioBtn);
        TCGirisRadioBtn.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        TCGirisRadioBtn.setText("TC İle Giriş");

        BireyselGirisTipiRDB.add(MusteriNoGirisRadioBtn);
        MusteriNoGirisRadioBtn.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        MusteriNoGirisRadioBtn.setText("Müşteri No İle Giriş");

        BireyselGirisTipiRDB.add(TelNoGirisRadioBtn);
        TelNoGirisRadioBtn.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        TelNoGirisRadioBtn.setText("Telefon No İle Giriş");

        BireyselTypeGirisTextF.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N

        BireyselSifreGirisPasswordTF.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N

        BireyselGirisSifreGoster.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        BireyselGirisSifreGoster.setText("Şifreyi Göster");

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel1.setText("TC / Müşteri No / Telefon");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel2.setText("Şifre");

        javax.swing.GroupLayout BireyselGirisYapPanelLayout = new javax.swing.GroupLayout(BireyselGirisYapPanel);
        BireyselGirisYapPanel.setLayout(BireyselGirisYapPanelLayout);
        BireyselGirisYapPanelLayout.setHorizontalGroup(
                BireyselGirisYapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(BireyselGirisYapPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(BireyselGirisYapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(29, 29, 29)
                                .addGroup(BireyselGirisYapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(BireyselTypeGirisTextF, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(BireyselSifreGirisPasswordTF, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BireyselGirisSifreGoster)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BireyselGirisYapPanelLayout.createSequentialGroup()
                                .addContainerGap(250, Short.MAX_VALUE)
                                .addComponent(TCGirisRadioBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(MusteriNoGirisRadioBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(TelNoGirisRadioBtn)
                                .addGap(190, 190, 190))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BireyselGirisYapPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BireyselGirisTamamlaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(405, 405, 405))
        );
        BireyselGirisYapPanelLayout.setVerticalGroup(
                BireyselGirisYapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(BireyselGirisYapPanelLayout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(BireyselGirisYapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                        .addComponent(TCGirisRadioBtn)
                                        .addComponent(MusteriNoGirisRadioBtn)
                                        .addComponent(TelNoGirisRadioBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(47, 47, 47)
                                .addGroup(BireyselGirisYapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(BireyselTypeGirisTextF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(BireyselGirisYapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(BireyselSifreGirisPasswordTF)
                                        .addComponent(BireyselGirisSifreGoster)
                                        .addComponent(jLabel2))
                                .addGap(36, 36, 36)
                                .addComponent(BireyselGirisTamamlaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(162, 162, 162))
        );

        PanelContainer.add(BireyselGirisYapPanel, "cardBireyselGirisYapPanel");

        KurumsalGirisTamamlaBtn.setBackground(new java.awt.Color(0, 102, 102));
        KurumsalGirisTamamlaBtn.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        KurumsalGirisTamamlaBtn.setText("Giriş Yap");
        KurumsalGirisTamamlaBtn.addActionListener(this::KurumsalGirisTamamlaBtnActionPerformed);

        KurumKoduGirisTextF.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N

        KurumsalSifreGirisPasswordTF.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N

        KurumsalGirisSifreGoster.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        KurumsalGirisSifreGoster.setText("Şifreyi Göster");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel3.setText("Kurum Kodu");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel4.setText("Şifre");

        javax.swing.GroupLayout KurumsalGirisPanelLayout = new javax.swing.GroupLayout(KurumsalGirisPanel);
        KurumsalGirisPanel.setLayout(KurumsalGirisPanelLayout);
        KurumsalGirisPanelLayout.setHorizontalGroup(
                KurumsalGirisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KurumsalGirisPanelLayout.createSequentialGroup()
                                .addContainerGap(289, Short.MAX_VALUE)
                                .addGroup(KurumsalGirisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(KurumsalGirisPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(18, 18, 18))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KurumsalGirisPanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel4)
                                                .addGap(31, 31, 31)))
                                .addGroup(KurumsalGirisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(KurumKoduGirisTextF, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(KurumsalGirisPanelLayout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addGroup(KurumsalGirisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(KurumsalGirisTamamlaBtn)
                                                        .addGroup(KurumsalGirisPanelLayout.createSequentialGroup()
                                                                .addComponent(KurumsalSifreGirisPasswordTF, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(12, 12, 12)
                                                                .addComponent(KurumsalGirisSifreGoster)))))
                                .addGap(249, 249, 249))
        );
        KurumsalGirisPanelLayout.setVerticalGroup(
                KurumsalGirisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(KurumsalGirisPanelLayout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addGroup(KurumsalGirisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(KurumKoduGirisTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addGap(32, 32, 32)
                                .addGroup(KurumsalGirisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(KurumsalSifreGirisPasswordTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(KurumsalGirisSifreGoster)
                                        .addComponent(jLabel4))
                                .addGap(48, 48, 48)
                                .addComponent(KurumsalGirisTamamlaBtn)
                                .addContainerGap(166, Short.MAX_VALUE))
        );

        PanelContainer.add(KurumsalGirisPanel, "cardKurumsalGirisPanel");

        BireyselKayıtTamamlaBtn.setBackground(new java.awt.Color(0, 102, 102));
        BireyselKayıtTamamlaBtn.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        BireyselKayıtTamamlaBtn.setText("Kayıt Ol");
        BireyselKayıtTamamlaBtn.addActionListener(this::BireyselKayıtTamamlaBtnActionPerformed);

        BireyselAdGirisTextF.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        BireyselSoyadGirisTextF.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        try {
            BireyselTcGirisFormattedTextF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            BireyselDogumTGirisFormattedTextF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        BireyselSehirGirisTextF.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        try {
            BireyselTelefonGirisTextF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        BireyselSifreKayitPasswordTF.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        BireyselKayitSifreGoster.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        BireyselKayitSifreGoster.setText("Şifreyi Göster");

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel5.setText("Ad");

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel6.setText("Soyad");

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel7.setText("TC Kimlik No");

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel8.setText("Doğum Tarihi");

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel9.setText("Şehir");

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel10.setText("Telefon");

        jLabel11.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel11.setText("Şifre Oluştur(6 Haneli)");

        javax.swing.GroupLayout BireyselKayitPanelLayout = new javax.swing.GroupLayout(BireyselKayitPanel);
        BireyselKayitPanel.setLayout(BireyselKayitPanelLayout);
        BireyselKayitPanelLayout.setHorizontalGroup(
                BireyselKayitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(BireyselKayitPanelLayout.createSequentialGroup()
                                .addGap(269, 269, 269)
                                .addGroup(BireyselKayitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(BireyselKayitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                        .addComponent(BireyselSoyadGirisTextF, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(BireyselTcGirisFormattedTextF, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(BireyselDogumTGirisFormattedTextF, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(BireyselSifreKayitPasswordTF, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(BireyselKayitPanelLayout.createSequentialGroup()
                                                .addGroup(BireyselKayitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                                        .addComponent(BireyselAdGirisTextF, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(BireyselTelefonGirisTextF, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(BireyselSehirGirisTextF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BireyselKayitSifreGoster)
                                .addGap(249, 249, 249))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BireyselKayitPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BireyselKayıtTamamlaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(418, 418, 418))
        );
        BireyselKayitPanelLayout.setVerticalGroup(
                BireyselKayitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(BireyselKayitPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(BireyselKayitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(BireyselAdGirisTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5))
                                .addGap(27, 27, 27)
                                .addGroup(BireyselKayitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(BireyselSoyadGirisTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(BireyselKayitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(BireyselTcGirisFormattedTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7))
                                .addGap(27, 27, 27)
                                .addGroup(BireyselKayitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(BireyselDogumTGirisFormattedTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(BireyselKayitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(BireyselSehirGirisTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9))
                                .addGap(11, 11, 11)
                                .addGroup(BireyselKayitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(BireyselTelefonGirisTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(BireyselKayitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(BireyselSifreKayitPasswordTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(BireyselKayitSifreGoster)
                                        .addComponent(jLabel11))
                                .addGap(18, 18, 18)
                                .addComponent(BireyselKayıtTamamlaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(49, Short.MAX_VALUE))
        );

        PanelContainer.add(BireyselKayitPanel, "cardBireyselKayitPanel");

        KurumsalKayıtTamamlaBtn.setBackground(new java.awt.Color(0, 102, 102));
        KurumsalKayıtTamamlaBtn.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        KurumsalKayıtTamamlaBtn.setText("Kayıt Ol");
        KurumsalKayıtTamamlaBtn.addActionListener(this::KurumsalKayıtTamamlaBtnActionPerformed);

        KurumsalAdGirisTextF.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        try {
            KurumsalTarihGirisFormattedTF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        KurumsalSehirGirisTextF.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        KurumsalSifreKayitPasswordTF.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        KurumsalKayitSifreGoster.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        KurumsalKayitSifreGoster.setText("Şifreyi Göster");

        jLabel12.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel12.setText("Kurum Adı");

        jLabel13.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel13.setText("Kurum Kuruluş Tarihi");

        jLabel14.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel14.setText("Kurumun Bulunduğu Şehir");

        jLabel15.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel15.setText("Şifre Oluştur(6 Haneli)");

        javax.swing.GroupLayout KurumsalKayitPanelLayout = new javax.swing.GroupLayout(KurumsalKayitPanel);
        KurumsalKayitPanel.setLayout(KurumsalKayitPanelLayout);
        KurumsalKayitPanelLayout.setHorizontalGroup(
                KurumsalKayitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(KurumsalKayitPanelLayout.createSequentialGroup()
                                .addGroup(KurumsalKayitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(KurumsalKayitPanelLayout.createSequentialGroup()
                                                .addGap(271, 271, 271)
                                                .addGroup(KurumsalKayitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel12)
                                                        .addComponent(jLabel13)
                                                        .addComponent(jLabel14)
                                                        .addComponent(jLabel15))
                                                .addGap(18, 18, 18)
                                                .addGroup(KurumsalKayitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                                        .addComponent(KurumsalAdGirisTextF, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(KurumsalSehirGirisTextF, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(KurumsalSifreKayitPasswordTF, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(KurumsalTarihGirisFormattedTF, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(KurumsalKayitSifreGoster))
                                        .addGroup(KurumsalKayitPanelLayout.createSequentialGroup()
                                                .addGap(444, 444, 444)
                                                .addComponent(KurumsalKayıtTamamlaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(247, Short.MAX_VALUE))
        );
        KurumsalKayitPanelLayout.setVerticalGroup(
                KurumsalKayitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(KurumsalKayitPanelLayout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addGroup(KurumsalKayitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(KurumsalAdGirisTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel12))
                                .addGap(18, 18, 18)
                                .addGroup(KurumsalKayitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel13)
                                        .addGroup(KurumsalKayitPanelLayout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addComponent(KurumsalTarihGirisFormattedTF, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(KurumsalKayitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(KurumsalSehirGirisTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel14))
                                .addGap(18, 18, 18)
                                .addGroup(KurumsalKayitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                        .addComponent(KurumsalKayitSifreGoster)
                                        .addComponent(KurumsalSifreKayitPasswordTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel15))
                                .addGap(29, 29, 29)
                                .addComponent(KurumsalKayıtTamamlaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(106, Short.MAX_VALUE))
        );

        PanelContainer.add(KurumsalKayitPanel, "cardKurumsalKayitPanel");

        GeriDonBtn.setBackground(new java.awt.Color(0, 102, 204));
        GeriDonBtn.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        GeriDonBtn.addActionListener(this::GeriDonBtnActionPerformed);

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
                MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(UstPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PanelContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(MainPanelLayout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(GeriDonBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MainPanelLayout.setVerticalGroup(
                MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(MainPanelLayout.createSequentialGroup()
                                .addComponent(UstPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(GeriDonBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(PanelContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        pack();
    }// </editor-fold>





    //===EVENTLER====
    private void GirisYapBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // 1. Eğer Bireysel seçiliyse -> Bireysel Giriş Ekranını ("kartBireysel") aç
        if (BireyselRadioBtn.isSelected()) {
            sayfaDegistir("cardBireyselGirisYapPanel");
        }

        // 2. Eğer Kurumsal seçiliyse -> Kurumsal Giriş Ekranını ("kartKurumsal") aç
        else if (KurumsalRadioBtn.isSelected()) {
            sayfaDegistir("cardKurumsalGirisPanel");
        }

        // 3. Hiçbiri seçili değilse kullanıcıyı uyar
        else {
            javax.swing.JOptionPane.showMessageDialog(this, "Lütfen giriş yapmak için bir hesap türü (Bireysel/Kurumsal) seçiniz!");
        }
    }

    private void HesapOlusturBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // 1. Eğer Bireysel seçiliyse -> Bireysel Kayıt Ekranına git
        if (BireyselRadioBtn.isSelected()) {
            // "kartBireyselKayit" ismini NetBeans'te vermiştik
            sayfaDegistir("cardBireyselKayitPanel");
        }

        // 2. Eğer Kurumsal seçiliyse -> Kurumsal Kayıt Ekranına git
        else if (KurumsalRadioBtn.isSelected()) {
            // "kartKurumsalKayit" ismini NetBeans'te vermiştik
            sayfaDegistir("cardKurumsalKayitPanel");
        }

        // 3. Hiçbiri seçili değilse uyar (Tedbir amaçlı)
        else {
            javax.swing.JOptionPane.showMessageDialog(this, "Lütfen önce hesap türünü (Bireysel/Kurumsal) seçiniz!");
        }
    }

    private void BireyselGirisTamamlaBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // 1. Verileri Al
        String girilenVeri = BireyselTypeGirisTextF.getText();
        String girilenSifre = new String(BireyselSifreGirisPasswordTF.getPassword());

        // 2. Giriş Türünü Belirle
        String loginType = "";

        if (TCGirisRadioBtn.isSelected()) {
            loginType = "TC";
        } else if (MusteriNoGirisRadioBtn.isSelected()) {
            loginType = "MUSTERI_NO";
        } else if (TelNoGirisRadioBtn.isSelected()) {
            loginType = "TELEFON";
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Lütfen bir giriş yöntemi (TC/No/Tel) seçiniz.");
            return;
        }

        // 3. Veritabanına Sor (Yeni metoda 'loginType'ı da gönderiyoruz)
        model.IndividualUser bulunanKullanici = Managers.DataBaseManager.getIndividualUserByLogin(girilenVeri, girilenSifre, loginType);

        if (bulunanKullanici != null) {
            // BAŞARILI!
            BireyselKullaniciUI anaEkran = new BireyselKullaniciUI(bulunanKullanici);
            anaEkran.setVisible(true);
            this.dispose(); // Giriş ekranını kapat
        } else {
            // BAŞARISIZ
            javax.swing.JOptionPane.showMessageDialog(this, "Giriş Başarısız! Bilgilerinizi kontrol ediniz.");
        }
    }

    private void KurumsalGirisTamamlaBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // 1. Verileri Al
        String kurumKodu = KurumKoduGirisTextF.getText();
        String sifre = new String(KurumsalSifreGirisPasswordTF.getPassword());

        // 2. Boşluk Kontrolü
        if(kurumKodu.isEmpty() || sifre.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Lütfen Kurum Kodu ve Şifrenizi giriniz.");
            return;
        }

        // 3. Veritabanına Sor
        model.EnterpriseUser girisYapanSirket = Managers.DataBaseManager.getEnterpriseUserByLogin(kurumKodu, sifre);

        if (girisYapanSirket != null) {
            // BAŞARILI!
            KurumsalKullaniciUI sirketEkrani = new KurumsalKullaniciUI(girisYapanSirket);
            sirketEkrani.setVisible(true);

            javax.swing.JOptionPane.showMessageDialog(this, "Giriş Başarılı! (Şirket: " + girisYapanSirket.getEnterpriseName() + ")");
            this.dispose(); // Giriş ekranını kapat

        } else {
            // BAŞARISIZ
            javax.swing.JOptionPane.showMessageDialog(this, "Hatalı Kurum Kodu veya Şifre!");
        }
    }

    private void BireyselKayıtTamamlaBtnActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            // 1. Formdaki Verileri Değişkenlere Alalım
            String ad = BireyselAdGirisTextF.getText();
            String soyad = BireyselSoyadGirisTextF.getText();
            String tc = BireyselTcGirisFormattedTextF.getText();
            String sehir = BireyselSehirGirisTextF.getText();
            String tel = BireyselTelefonGirisTextF.getText();
            String sifre = new String(BireyselSifreKayitPasswordTF.getPassword());

            // Tarih verisini al
            String tarihMetni = BireyselDogumTGirisFormattedTextF.getText();

            // 2. Boş Alan Kontrolü
            if (ad.trim().isEmpty() || soyad.trim().isEmpty() || sehir.trim().isEmpty() || sifre.trim().isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this, "Lütfen Ad, Soyad, Şehir ve Şifre alanlarını eksiksiz doldurunuz.");
                return;
            }

            // 3. Tarih Dönüştürme
            java.time.format.DateTimeFormatter formatlayici = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");
            java.time.LocalDate dogumTarihi = java.time.LocalDate.parse(tarihMetni, formatlayici);

            // 4. Veritabanına Kaydet ve MÜŞTERİ NO'YU AL
            // Artık metot bize String olarak ID döndürüyor.
            String olusanMusteriNo = Managers.DataBaseManager.addIndividualUser(tc, ad, soyad, sifre, dogumTarihi, sehir, tel);

            // 5. Sonucu Kontrol Et ve Ekrana Yaz
            if (olusanMusteriNo != null) {
                // Başarılıysa ID'yi göster
                String mesaj = "Kayıt İşlemi Başarılı!\n\n" +
                        "Müşteri Numaranız: " + olusanMusteriNo + "\n\n" +
                        "(Lütfen bu numarayı not ediniz, giriş yaparken kullanacaksınız.)";

                javax.swing.JOptionPane.showMessageDialog(this, mesaj, "Aramıza Hoş Geldiniz", javax.swing.JOptionPane.INFORMATION_MESSAGE);

                // Giriş ekranına yönlendir
                sayfaDegistir("cardBireyselGirisYapPanel");

            } else {
                // ID null geldiyse hata vardır
                javax.swing.JOptionPane.showMessageDialog(this, "Kayıt sırasında bir hata oluştu! Lütfen bilgileri kontrol ediniz.");
            }

        } catch (java.time.format.DateTimeParseException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Hatalı Tarih! Lütfen Gün/Ay/Yıl formatında giriniz.");
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Bir hata oluştu: " + ex.getMessage());
        }
    }

    private void KurumsalKayıtTamamlaBtnActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            // 1. Verileri Al
            String sirketAdi = KurumsalAdGirisTextF.getText();
            String sehirHQ = KurumsalSehirGirisTextF.getText();
            String sifre = new String(KurumsalSifreKayitPasswordTF.getPassword());
            String tarihMetni = KurumsalTarihGirisFormattedTF.getText();

            // 2. Kontrol
            if (sirketAdi.trim().isEmpty() || sehirHQ.trim().isEmpty() || sifre.trim().isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this, "Lütfen tüm alanları doldurunuz.");
                return;
            }

            // 3. Tarih
            java.time.format.DateTimeFormatter formatlayici = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");
            java.time.LocalDate kurulusTarihi = java.time.LocalDate.parse(tarihMetni, formatlayici);

            // 4. Kaydet ve KODU AL (String olusanKod)
            String olusanKod = Managers.DataBaseManager.addEnterpriseUser(sirketAdi, sifre, kurulusTarihi, sehirHQ);

            if (olusanKod != null) {
                // 5. Kodu Mesajda Göster
                String mesaj = "Kurumsal Kayıt Başarılı!\n\n" +
                        "GİRİŞ İÇİN KURUM KODUNUZ: " + olusanKod + "\n\n" +
                        "Lütfen bu kodu bir yere not ediniz.";

                javax.swing.JOptionPane.showMessageDialog(this, mesaj, "Kayıt Bilgisi", javax.swing.JOptionPane.INFORMATION_MESSAGE);

                // 6. Giriş Ekranına Yönlendir
                sayfaDegistir("cardKurumsalGirisPanel");
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Kayıt sırasında bir hata oluştu!");
            }

        } catch (java.time.format.DateTimeParseException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Hatalı Tarih! Lütfen dd/MM/yyyy formatında giriniz.");
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Hata: " + ex.getMessage());
        }
    }

    private void GeriDonBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // Ana menüye (Seçim Ekranına) dön
        sayfaDegistir("cardFirstPanel");
    }

    private void AdminControlsBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // Kullanıcıya bilgi ver
        javax.swing.JOptionPane.showMessageDialog(this,
                "Admin Paneli Konsolda (Output Ekranında) başlatıldı.\n" +
                        "Lütfen IDE'nizin altındaki Output/Terminal penceresini kullanın.");

        // Konsol işlemini yeni bir Thread içinde başlatıyoruz
        // Böylece UI donmuyor.
        new Thread(() -> {
            UI.AdminConsole.startConsole();
        }).start();
    }



    //======EVENTLER-SON=========

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Managers.DataBaseManager.start();
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new MainMenuUI().setVisible(true));
    }

    //=======Kendi özel fonksiyonlarım=========
    private void sayfaDegistir(String kartIsmi) {
        // 1. Kartı Değiştir
        java.awt.CardLayout layout = (java.awt.CardLayout) PanelContainer.getLayout();
        layout.show(PanelContainer, kartIsmi);

        // 2. Buton Kontrolü Yap
        if (kartIsmi.equals("cardFirstPanel")) {
            // Eğer Ana Menüye dönüldüyse butonu GİZLE
            GeriDonBtn.setVisible(false);
        } else {
            // Diğer tüm sayfalarda butonu GÖSTER
            GeriDonBtn.setVisible(true);
        }
    }

    // --- TARİH GÖSTERME METODU ---
    private void tarihiGuncelle() {
        // TimeManager'dan tarihi çek
        java.time.LocalDate bugun = Managers.TimeManager.getCurrentDate();

        // Label'a yazdır (Değişken adın DateLabel değilse burayı düzelt!)
        TarihveSaatLabel.setText(bugun.toString());
    }

    // --- ŞİFRE GÖSTER / GİZLE AYARLARI ---
    private void sifreGosterGizleAyarlari() {
        // 1. BİREYSEL GİRİŞ EKRANI
        BireyselGirisSifreGoster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (BireyselGirisSifreGoster.isSelected()) {
                    BireyselSifreGirisPasswordTF.setEchoChar((char) 0); // Göster
                } else {
                    BireyselSifreGirisPasswordTF.setEchoChar('*'); // Gizle
                }
            }
        });

        // 2. KURUMSAL GİRİŞ EKRANI
        KurumsalGirisSifreGoster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (KurumsalGirisSifreGoster.isSelected()) {
                    KurumsalSifreGirisPasswordTF.setEchoChar((char) 0); // Göster
                } else {
                    KurumsalSifreGirisPasswordTF.setEchoChar('*'); // Gizle
                }
            }
        });

        // 3. BİREYSEL KAYIT EKRANI
        BireyselKayitSifreGoster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (BireyselKayitSifreGoster.isSelected()) {
                    BireyselSifreKayitPasswordTF.setEchoChar((char) 0); // Göster
                } else {
                    BireyselSifreKayitPasswordTF.setEchoChar('*'); // Gizle
                }
            }
        });

        // 4. KURUMSAL KAYIT EKRANI
        KurumsalKayitSifreGoster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (KurumsalKayitSifreGoster.isSelected()) {
                    KurumsalSifreKayitPasswordTF.setEchoChar((char) 0); // Göster
                } else {
                    KurumsalSifreKayitPasswordTF.setEchoChar('*'); // Gizle
                }
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton AdminControlsBtn;
    private javax.swing.ButtonGroup AnaMenuKullaniciTipiRDB;
    private javax.swing.JLabel BankaAdiLabel;
    private javax.swing.JTextField BireyselAdGirisTextF;
    private javax.swing.JFormattedTextField BireyselDogumTGirisFormattedTextF;
    private javax.swing.JCheckBox BireyselGirisSifreGoster;
    private javax.swing.JButton BireyselGirisTamamlaBtn;
    private javax.swing.ButtonGroup BireyselGirisTipiRDB;
    private javax.swing.JPanel BireyselGirisYapPanel;
    private javax.swing.JPanel BireyselKayitPanel;
    private javax.swing.JCheckBox BireyselKayitSifreGoster;
    private javax.swing.JButton BireyselKayıtTamamlaBtn;
    private javax.swing.JRadioButton BireyselRadioBtn;
    private javax.swing.JTextField BireyselSehirGirisTextF;
    private javax.swing.JPasswordField BireyselSifreGirisPasswordTF;
    private javax.swing.JPasswordField BireyselSifreKayitPasswordTF;
    private javax.swing.JTextField BireyselSoyadGirisTextF;
    private javax.swing.JFormattedTextField BireyselTcGirisFormattedTextF;
    private javax.swing.JFormattedTextField BireyselTelefonGirisTextF;
    private javax.swing.JTextField BireyselTypeGirisTextF;
    private javax.swing.JPanel FirstPanel;
    private javax.swing.JButton GeriDonBtn;
    private javax.swing.JButton GirisYapBtn;
    private javax.swing.JButton HesapOlusturBtn;
    private javax.swing.JTextField KurumKoduGirisTextF;
    private javax.swing.JTextField KurumsalAdGirisTextF;
    private javax.swing.JPanel KurumsalGirisPanel;
    private javax.swing.JCheckBox KurumsalGirisSifreGoster;
    private javax.swing.JButton KurumsalGirisTamamlaBtn;
    private javax.swing.JPanel KurumsalKayitPanel;
    private javax.swing.JCheckBox KurumsalKayitSifreGoster;
    private javax.swing.JButton KurumsalKayıtTamamlaBtn;
    private javax.swing.JRadioButton KurumsalRadioBtn;
    private javax.swing.JTextField KurumsalSehirGirisTextF;
    private javax.swing.JPasswordField KurumsalSifreGirisPasswordTF;
    private javax.swing.JPasswordField KurumsalSifreKayitPasswordTF;
    private javax.swing.JFormattedTextField KurumsalTarihGirisFormattedTF;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JRadioButton MusteriNoGirisRadioBtn;
    private javax.swing.JPanel PanelContainer;
    private javax.swing.JRadioButton TCGirisRadioBtn;
    private javax.swing.JLabel TarihveSaatLabel;
    private javax.swing.JRadioButton TelNoGirisRadioBtn;
    private javax.swing.JPanel UstPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration

    private void bilesenBoyutlariniSabitle() {
        java.awt.Dimension standartBoyut = new java.awt.Dimension(180, 30);
        java.awt.Dimension genisBoyut = new java.awt.Dimension(250, 30);

        // 1. BİREYSEL GİRİŞ EKRANI
        BireyselTypeGirisTextF.setPreferredSize(standartBoyut);
        BireyselSifreGirisPasswordTF.setPreferredSize(standartBoyut);

        // 2. KURUMSAL GİRİŞ EKRANI
        KurumKoduGirisTextF.setPreferredSize(standartBoyut);
        KurumsalSifreGirisPasswordTF.setPreferredSize(standartBoyut);

        // 3. BİREYSEL KAYIT EKRANI
        BireyselAdGirisTextF.setPreferredSize(standartBoyut);
        BireyselSoyadGirisTextF.setPreferredSize(standartBoyut);
        BireyselTcGirisFormattedTextF.setPreferredSize(standartBoyut);
        BireyselDogumTGirisFormattedTextF.setPreferredSize(standartBoyut);
        BireyselSehirGirisTextF.setPreferredSize(standartBoyut);
        BireyselTelefonGirisTextF.setPreferredSize(standartBoyut);
        BireyselSifreKayitPasswordTF.setPreferredSize(standartBoyut);

        // 4. KURUMSAL KAYIT EKRANI
        KurumsalAdGirisTextF.setPreferredSize(genisBoyut);
        KurumsalTarihGirisFormattedTF.setPreferredSize(standartBoyut);
        KurumsalSehirGirisTextF.setPreferredSize(standartBoyut);
        KurumsalSifreKayitPasswordTF.setPreferredSize(standartBoyut);
    }
}

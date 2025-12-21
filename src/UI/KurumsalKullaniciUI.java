package UI;

import javax.swing.table.DefaultTableModel;

public class KurumsalKullaniciUI extends javax.swing.JFrame {

    private String seciliSubscriptionId = "";
    private model.EnterpriseUser aktifSirket;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(KurumsalKullaniciUI.class.getName());

    public KurumsalKullaniciUI(model.EnterpriseUser sirket) {
        this.aktifSirket = sirket;
        initComponents();

        AnaSayfaBtn.setIcon(UI.IconHelper.createIcon("/resources/home.png", 32, 32));
        AboneYonetimiBtn.setIcon(UI.IconHelper.createIcon("/resources/subscription.png", 32, 32));
        FaturaYonetimiBtn.setIcon(UI.IconHelper.createIcon("/resources/bill.png", 32, 32));

        // Verileri Yükle
        sirketBilgileriniGoster();
        anaSayfaGuncelle();
        aboneListesiniDoldur(); // Tabloyu Doldur
        faturaAboneListesiniDoldur(); // Fatura tablosunu doldur
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        YeniAboneFrame = new javax.swing.JFrame();
        YeniAbonePanel = new javax.swing.JPanel();
        YeniAboneAdTextF = new javax.swing.JTextField();
        YeniAboneSoyadTextF = new javax.swing.JTextField();
        YeniAboneTCTextF = new javax.swing.JTextField();
        YeniAboneFaturaGünüTextF = new javax.swing.JTextField();
        YeniAboneAylıkOdemeTutarTextF = new javax.swing.JTextField();
        YeniAboneOlusturBtn = new javax.swing.JButton();
        lbl2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        FaturaOlusturmaFrame = new javax.swing.JFrame();
        FaturaOlusturmaPanel = new javax.swing.JPanel();
        FaturaOlusturalacakKisiAdSoyadLabel = new javax.swing.JLabel();
        FaturaTutariTextF = new javax.swing.JTextField();
        FaturaSonTarihFTextF = new javax.swing.JFormattedTextField();
        FaturaOlusturBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        MainPanel = new javax.swing.JPanel();
        UstPanel = new javax.swing.JPanel();
        lbl1 = new javax.swing.JLabel();
        KurumAdiLabel = new javax.swing.JLabel();
        KurumKodLabel = new javax.swing.JLabel();
        YonlendirmePanel = new javax.swing.JPanel();
        AnaSayfaBtn = new javax.swing.JButton();
        AboneYonetimiBtn = new javax.swing.JButton();
        FaturaYonetimiBtn = new javax.swing.JButton();
        PanelContainer = new javax.swing.JPanel();
        AnaSayfaPanel = new javax.swing.JPanel();
        AnaSayfaKurumBakiyesiLabel = new javax.swing.JLabel();
        AnaSayfaKurumBeklenenTahsilatLabel = new javax.swing.JLabel();
        AnaSayfaKurumAboneSayisiLabel = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        AboneYonetimiPanel = new javax.swing.JPanel();
        AboneListesiTableScrollPane = new javax.swing.JScrollPane();
        AboneListesiTable = new javax.swing.JTable();
        AboneYonetimiYeniAboneBtn = new javax.swing.JButton();
        FaturaYonetimiPanel = new javax.swing.JPanel();
        FaturaOlusturmaBtn = new javax.swing.JButton();
        FaturaAboneTableScrollPane = new javax.swing.JScrollPane();
        FaturaAboneTable = new javax.swing.JTable();

        YeniAboneAdTextF.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        YeniAboneSoyadTextF.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        YeniAboneTCTextF.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        YeniAboneFaturaGünüTextF.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        YeniAboneAylıkOdemeTutarTextF.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        YeniAboneOlusturBtn.setBackground(new java.awt.Color(0, 102, 153));
        YeniAboneOlusturBtn.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        YeniAboneOlusturBtn.setText("Abone Oluştur");
        YeniAboneOlusturBtn.addActionListener(this::YeniAboneOlusturBtnActionPerformed);

        lbl2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        lbl2.setText("Yeni Abone Oluşturucu");

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel1.setText("Ad");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel2.setText("Soyad");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel3.setText("TC");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel4.setText("Fatura Günü");

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel5.setText("Aylık Ödeme Tutarı");

        javax.swing.GroupLayout YeniAbonePanelLayout = new javax.swing.GroupLayout(YeniAbonePanel);
        YeniAbonePanel.setLayout(YeniAbonePanelLayout);
        YeniAbonePanelLayout.setHorizontalGroup(
                YeniAbonePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(YeniAbonePanelLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(YeniAbonePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(YeniAbonePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                        .addComponent(YeniAboneAdTextF)
                                        .addComponent(YeniAboneSoyadTextF)
                                        .addComponent(YeniAboneTCTextF)
                                        .addComponent(YeniAboneFaturaGünüTextF)
                                        .addComponent(YeniAboneAylıkOdemeTutarTextF)
                                        .addComponent(lbl2)
                                        .addComponent(YeniAboneOlusturBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(148, 148, 148))
        );
        YeniAbonePanelLayout.setVerticalGroup(
                YeniAbonePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(YeniAbonePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbl2)
                                .addGap(27, 27, 27)
                                .addGroup(YeniAbonePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(YeniAboneAdTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(YeniAbonePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(YeniAboneSoyadTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(YeniAbonePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(YeniAboneTCTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(YeniAbonePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(YeniAboneFaturaGünüTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(YeniAbonePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(YeniAboneAylıkOdemeTutarTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5))
                                .addGap(39, 39, 39)
                                .addComponent(YeniAboneOlusturBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout YeniAboneFrameLayout = new javax.swing.GroupLayout(YeniAboneFrame.getContentPane());
        YeniAboneFrame.getContentPane().setLayout(YeniAboneFrameLayout);
        YeniAboneFrameLayout.setHorizontalGroup(
                YeniAboneFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(YeniAbonePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        YeniAboneFrameLayout.setVerticalGroup(
                YeniAboneFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(YeniAboneFrameLayout.createSequentialGroup()
                                .addComponent(YeniAbonePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 25, Short.MAX_VALUE))
        );

        FaturaOlusturalacakKisiAdSoyadLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        FaturaOlusturalacakKisiAdSoyadLabel.setText("FaturaOlusturalacakKisiAdSoyad");

        FaturaTutariTextF.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        try {
            FaturaSonTarihFTextF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        FaturaOlusturBtn.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        FaturaOlusturBtn.setText("Fatura Oluştur");
        FaturaOlusturBtn.addActionListener(this::FaturaOlusturBtnActionPerformed);

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel6.setText("Ad Soyad:");

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel7.setText("Fatura Tutarı:");

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel8.setText("Son Ödeme Tarihi:");

        javax.swing.GroupLayout FaturaOlusturmaPanelLayout = new javax.swing.GroupLayout(FaturaOlusturmaPanel);
        FaturaOlusturmaPanel.setLayout(FaturaOlusturmaPanelLayout);
        FaturaOlusturmaPanelLayout.setHorizontalGroup(
                FaturaOlusturmaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FaturaOlusturmaPanelLayout.createSequentialGroup()
                                .addContainerGap(51, Short.MAX_VALUE)
                                .addGroup(FaturaOlusturmaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(FaturaOlusturmaPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(FaturaOlusturalacakKisiAdSoyadLabel))
                                        .addGroup(FaturaOlusturmaPanelLayout.createSequentialGroup()
                                                .addGroup(FaturaOlusturmaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel7)
                                                        .addComponent(jLabel8))
                                                .addGap(25, 25, 25)
                                                .addGroup(FaturaOlusturmaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(FaturaTutariTextF)
                                                        .addComponent(FaturaSonTarihFTextF, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(FaturaOlusturmaPanelLayout.createSequentialGroup()
                                                .addGap(62, 62, 62)
                                                .addComponent(FaturaOlusturBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(29, 29, 29))
        );
        FaturaOlusturmaPanelLayout.setVerticalGroup(
                FaturaOlusturmaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(FaturaOlusturmaPanelLayout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(FaturaOlusturmaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(FaturaOlusturalacakKisiAdSoyadLabel)
                                        .addComponent(jLabel6))
                                .addGap(31, 31, 31)
                                .addGroup(FaturaOlusturmaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(FaturaTutariTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(FaturaOlusturmaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(FaturaSonTarihFTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8))
                                .addGap(31, 31, 31)
                                .addComponent(FaturaOlusturBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout FaturaOlusturmaFrameLayout = new javax.swing.GroupLayout(FaturaOlusturmaFrame.getContentPane());
        FaturaOlusturmaFrame.getContentPane().setLayout(FaturaOlusturmaFrameLayout);
        FaturaOlusturmaFrameLayout.setHorizontalGroup(
                FaturaOlusturmaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(FaturaOlusturmaPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        FaturaOlusturmaFrameLayout.setVerticalGroup(
                FaturaOlusturmaFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(FaturaOlusturmaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        UstPanel.setBackground(new java.awt.Color(0, 102, 255));

        lbl1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        lbl1.setText("DİNO BANK");

        KurumAdiLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        KurumAdiLabel.setText("KurumAdı");

        KurumKodLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        KurumKodLabel.setText("KurumKod");

        javax.swing.GroupLayout UstPanelLayout = new javax.swing.GroupLayout(UstPanel);
        UstPanel.setLayout(UstPanelLayout);
        UstPanelLayout.setHorizontalGroup(
                UstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(UstPanelLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(KurumAdiLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl1)
                                .addGap(318, 318, 318)
                                .addComponent(KurumKodLabel)
                                .addGap(76, 76, 76))
        );
        UstPanelLayout.setVerticalGroup(
                UstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(UstPanelLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(UstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(KurumAdiLabel)
                                        .addGroup(UstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(KurumKodLabel)
                                                .addComponent(lbl1)))
                                .addContainerGap(33, Short.MAX_VALUE))
        );

        AnaSayfaBtn.addActionListener(this::AnaSayfaBtnActionPerformed);

        AboneYonetimiBtn.addActionListener(this::AboneYonetimiBtnActionPerformed);

        FaturaYonetimiBtn.addActionListener(this::FaturaYonetimiBtnActionPerformed);

        javax.swing.GroupLayout YonlendirmePanelLayout = new javax.swing.GroupLayout(YonlendirmePanel);
        YonlendirmePanel.setLayout(YonlendirmePanelLayout);
        YonlendirmePanelLayout.setHorizontalGroup(
                YonlendirmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, YonlendirmePanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(AnaSayfaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AboneYonetimiBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FaturaYonetimiBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(404, 404, 404))
        );
        YonlendirmePanelLayout.setVerticalGroup(
                YonlendirmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(YonlendirmePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(YonlendirmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(AnaSayfaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(AboneYonetimiBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(FaturaYonetimiBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelContainer.setLayout(new java.awt.CardLayout());

        AnaSayfaKurumBakiyesiLabel.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        AnaSayfaKurumBakiyesiLabel.setText("mevcutbakiye");

        AnaSayfaKurumBeklenenTahsilatLabel.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        AnaSayfaKurumBeklenenTahsilatLabel.setText("beklenentahsilat");

        AnaSayfaKurumAboneSayisiLabel.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        AnaSayfaKurumAboneSayisiLabel.setText("abonesayısı");

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel9.setText("Mevcut Bakiye:");

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel10.setText("Aylık Beklenen Minimum Tahsilat:");

        jLabel11.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel11.setText("Abone Sayısı:");

        javax.swing.GroupLayout AnaSayfaPanelLayout = new javax.swing.GroupLayout(AnaSayfaPanel);
        AnaSayfaPanel.setLayout(AnaSayfaPanelLayout);
        AnaSayfaPanelLayout.setHorizontalGroup(
                AnaSayfaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(AnaSayfaPanelLayout.createSequentialGroup()
                                .addGap(184, 184, 184)
                                .addGroup(AnaSayfaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(AnaSayfaPanelLayout.createSequentialGroup()
                                                .addGap(193, 193, 193)
                                                .addComponent(jLabel9)
                                                .addGap(18, 18, 18)
                                                .addComponent(AnaSayfaKurumBakiyesiLabel))
                                        .addGroup(AnaSayfaPanelLayout.createSequentialGroup()
                                                .addGroup(AnaSayfaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel10)
                                                        .addComponent(jLabel11))
                                                .addGap(18, 18, 18)
                                                .addGroup(AnaSayfaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(AnaSayfaKurumAboneSayisiLabel)
                                                        .addComponent(AnaSayfaKurumBeklenenTahsilatLabel))))
                                .addContainerGap(296, Short.MAX_VALUE))
        );
        AnaSayfaPanelLayout.setVerticalGroup(
                AnaSayfaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(AnaSayfaPanelLayout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addGroup(AnaSayfaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(AnaSayfaKurumBakiyesiLabel)
                                        .addComponent(jLabel9))
                                .addGap(58, 58, 58)
                                .addGroup(AnaSayfaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(AnaSayfaKurumBeklenenTahsilatLabel)
                                        .addComponent(jLabel10))
                                .addGap(57, 57, 57)
                                .addGroup(AnaSayfaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(AnaSayfaKurumAboneSayisiLabel)
                                        .addComponent(jLabel11))
                                .addContainerGap(195, Short.MAX_VALUE))
        );

        PanelContainer.add(AnaSayfaPanel, "cardAnaSayfaPanel");

        AboneListesiTable.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        AboneListesiTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String [] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        AboneListesiTableScrollPane.setViewportView(AboneListesiTable);

        AboneYonetimiYeniAboneBtn.setBackground(new java.awt.Color(0, 102, 153));
        AboneYonetimiYeniAboneBtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        AboneYonetimiYeniAboneBtn.setText("Yeni Abone Kayıt");
        AboneYonetimiYeniAboneBtn.addActionListener(this::AboneYonetimiYeniAboneBtnActionPerformed);

        javax.swing.GroupLayout AboneYonetimiPanelLayout = new javax.swing.GroupLayout(AboneYonetimiPanel);
        AboneYonetimiPanel.setLayout(AboneYonetimiPanelLayout);
        AboneYonetimiPanelLayout.setHorizontalGroup(
                AboneYonetimiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(AboneYonetimiPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(AboneListesiTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 994, Short.MAX_VALUE))
                        .addGroup(AboneYonetimiPanelLayout.createSequentialGroup()
                                .addGap(386, 386, 386)
                                .addComponent(AboneYonetimiYeniAboneBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        AboneYonetimiPanelLayout.setVerticalGroup(
                AboneYonetimiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AboneYonetimiPanelLayout.createSequentialGroup()
                                .addComponent(AboneListesiTableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(AboneYonetimiYeniAboneBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                                .addGap(20, 20, 20))
        );

        PanelContainer.add(AboneYonetimiPanel, "cardAboneYonetimiPanel");

        FaturaOlusturmaBtn.setBackground(new java.awt.Color(0, 102, 153));
        FaturaOlusturmaBtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        FaturaOlusturmaBtn.setText("Fatura Oluştur");
        FaturaOlusturmaBtn.addActionListener(this::FaturaOlusturmaBtnActionPerformed);

        FaturaAboneTable.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        FaturaAboneTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String [] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        FaturaAboneTableScrollPane.setViewportView(FaturaAboneTable);

        javax.swing.GroupLayout FaturaYonetimiPanelLayout = new javax.swing.GroupLayout(FaturaYonetimiPanel);
        FaturaYonetimiPanel.setLayout(FaturaYonetimiPanelLayout);
        FaturaYonetimiPanelLayout.setHorizontalGroup(
                FaturaYonetimiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(FaturaYonetimiPanelLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(FaturaOlusturmaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(FaturaAboneTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE)
                                .addContainerGap())
        );
        FaturaYonetimiPanelLayout.setVerticalGroup(
                FaturaYonetimiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(FaturaYonetimiPanelLayout.createSequentialGroup()
                                .addGroup(FaturaYonetimiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(FaturaYonetimiPanelLayout.createSequentialGroup()
                                                .addGap(24, 24, 24)
                                                .addComponent(FaturaAboneTableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(FaturaYonetimiPanelLayout.createSequentialGroup()
                                                .addGap(395, 395, 395)
                                                .addComponent(FaturaOlusturmaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(21, Short.MAX_VALUE))
        );

        PanelContainer.add(FaturaYonetimiPanel, "cardFaturaYonetimiPanel");

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
                MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(YonlendirmePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PanelContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(UstPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MainPanelLayout.setVerticalGroup(
                MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                                .addComponent(UstPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PanelContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(YonlendirmePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void AnaSayfaBtnActionPerformed(java.awt.event.ActionEvent evt) {
        mainSayfaDegistir("cardAnaSayfaPanel");
    }

    private void AboneYonetimiBtnActionPerformed(java.awt.event.ActionEvent evt) {
        mainSayfaDegistir("cardAboneYonetimiPanel");
    }

    private void FaturaYonetimiBtnActionPerformed(java.awt.event.ActionEvent evt) {
        mainSayfaDegistir("cardFaturaYonetimiPanel");
    }

    private void AboneYonetimiYeniAboneBtnActionPerformed(java.awt.event.ActionEvent evt) {
        YeniAboneFrame.pack();
        YeniAboneFrame.setLocationRelativeTo(this);
        YeniAboneFrame.setVisible(true);
    }

    private void FaturaOlusturmaBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // 1. Tablodan seçili satırı al
        int selectedRow = FaturaAboneTable.getSelectedRow();

        if (selectedRow != -1) {
            // 2. Abone ID'sini (SubscriptionId) alıp değişkene kaydet
            // (DataBaseManager.getAboneler metodunda 0. sütuna ID koymuştuk)
            this.seciliSubscriptionId = FaturaAboneTable.getValueAt(selectedRow, 0).toString();

            // İsmi alıp ekrana yaz (Görsellik için)
            String adSoyad = FaturaAboneTable.getValueAt(selectedRow, 2).toString();
            FaturaOlusturalacakKisiAdSoyadLabel.setText(adSoyad);

            // Pencereyi Aç
            FaturaOlusturmaFrame.pack();
            FaturaOlusturmaFrame.setLocationRelativeTo(this);
            FaturaOlusturmaFrame.setVisible(true);
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Lütfen tablodan fatura keseceğiniz aboneyi seçiniz.");
        }
    }

    private void YeniAboneOlusturBtnActionPerformed(java.awt.event.ActionEvent evt) {
        String ad = YeniAboneAdTextF.getText();
        String soyad = YeniAboneSoyadTextF.getText();
        String tc = YeniAboneTCTextF.getText();
        String gunStr = YeniAboneFaturaGünüTextF.getText();
        String tutarStr = YeniAboneAylıkOdemeTutarTextF.getText();

        if (ad.isEmpty() || tc.isEmpty() || gunStr.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(YeniAboneFrame, "Lütfen tüm alanları doldurunuz.");
            return;
        }

        try {
            int gun = Integer.parseInt(gunStr);
            double tutar = Double.parseDouble(tutarStr);

            // Veritabanına Kaydet
            boolean sonuc = Managers.DataBaseManager.addSubscription(aktifSirket.getUserId(), tc, ad, soyad, gun, tutar);

            if (sonuc) {
                javax.swing.JOptionPane.showMessageDialog(YeniAboneFrame, "Abone Başarıyla Eklendi!");
                YeniAboneFrame.dispose(); // Pencereyi kapat

                // Ekranları Tazele
                aboneListesiniDoldur();
                faturaAboneListesiniDoldur();
                anaSayfaGuncelle();
            } else {
                javax.swing.JOptionPane.showMessageDialog(YeniAboneFrame, "Hata: Bu TC'ye sahip bir banka müşterisi bulunamadı!");
            }

        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(YeniAboneFrame, "Lütfen sayısal değerleri doğru giriniz.");
        }
    }

    private void FaturaOlusturBtnActionPerformed(java.awt.event.ActionEvent evt) {
        String tutarStr = FaturaTutariTextF.getText();

        if (this.seciliSubscriptionId.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(FaturaOlusturmaFrame, "Hata: Abone seçimi kayboldu.");
            return;
        }

        try {
            double tutar = Double.parseDouble(tutarStr);

            // --- KRİTİK NOKTA: Veritabanına Kaydet ---
            boolean sonuc = Managers.DataBaseManager.addInvoice(this.seciliSubscriptionId, tutar);

            if (sonuc) {
                javax.swing.JOptionPane.showMessageDialog(FaturaOlusturmaFrame, "Fatura Başarıyla Kesildi ve Kullanıcıya Gönderildi!");

                // İstatistikleri Güncelle (Beklenen Tahsilat artmalı)
                anaSayfaGuncelle();

                FaturaOlusturmaFrame.dispose(); // Pencereyi kapat
            } else {
                javax.swing.JOptionPane.showMessageDialog(FaturaOlusturmaFrame, "Fatura kaydedilirken bir hata oluştu!");
            }

        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(FaturaOlusturmaFrame, "Lütfen geçerli bir tutar giriniz!");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
        java.awt.EventQueue.invokeLater(() -> new KurumsalKullaniciUI(null).setVisible(true));
    }

    //=======Kendi özel fonksiyonlarım=========
    private void mainSayfaDegistir(String kartIsmi) {
        // 1. Kartı Değiştir
        java.awt.CardLayout layout = (java.awt.CardLayout) PanelContainer.getLayout();
        layout.show(PanelContainer, kartIsmi);
    }

    // =============================================================
    // YARDIMCI METOTLAR (LOGIC)
    // =============================================================

    // 1. Şirket Bilgilerini Üst Panele Yaz
    private void sirketBilgileriniGoster() {
        if (aktifSirket != null) {
            KurumAdiLabel.setText(aktifSirket.getEnterpriseName());
            KurumKodLabel.setText("Kurum Kodu: " + aktifSirket.getUserId());
        }
    }

    // 2. Ana Sayfa İstatistiklerini Güncelle
    private void anaSayfaGuncelle() {
        if (aktifSirket == null) return;

        // A. Bakiyeyi Çek (Vadesiz TL Hesabı)
        String[] hesapBilgisi = Managers.DataBaseManager.getAccountDetails(aktifSirket.getUserId(), "TL");
        double bakiye = Double.parseDouble(hesapBilgisi[0]);
        AnaSayfaKurumBakiyesiLabel.setText(String.format("Kasa Bakiyesi: %,.2f TL", bakiye));

        // B. Abone Sayısını Çek
        int aboneSayisi = Managers.DataBaseManager.getAboneSayisi(aktifSirket.getUserId());
        AnaSayfaKurumAboneSayisiLabel.setText("Toplam Abone: " + aboneSayisi);

        // C. Beklenen Tahsilat (Aboneliklerden Gelecek Sabit Gelir)
        double beklenen = Managers.DataBaseManager.getBeklenenTahsilat(aktifSirket.getUserId());
        AnaSayfaKurumBeklenenTahsilatLabel.setText(String.format("Aylık Beklenen Tahsilat: %,.2f TL", beklenen));
    }

    // 3. Abone Listesi Tablosunu Doldur
    private void aboneListesiniDoldur() {
        if (aktifSirket == null) return;

        // Veritabanından Aboneleri Çek
        DefaultTableModel model = (DefaultTableModel) AboneListesiTable.getModel();
        model.setRowCount(0); // Tabloyu temizle
        model.setColumnIdentifiers(new String[]{"Abone No", "TC No", "Adı Soyadı", "Fatura Günü", "Sabit Tutar"});

        java.util.ArrayList<String[]> aboneler = Managers.DataBaseManager.getAboneler(aktifSirket.getUserId());

        for (String[] abone : aboneler) {
            model.addRow(abone);
        }
    }

    // 4. Fatura Kesilecek Aboneler Tablosunu Doldur (Aynısı)
    private void faturaAboneListesiniDoldur() {
        if (aktifSirket == null) return;

        DefaultTableModel model = (DefaultTableModel) FaturaAboneTable.getModel();
        model.setRowCount(0);
        model.setColumnIdentifiers(new String[]{"Abone No", "TC No", "Adı Soyadı"});

        java.util.ArrayList<String[]> aboneler = Managers.DataBaseManager.getAboneler(aktifSirket.getUserId());

        for (String[] abone : aboneler) {
            // Sadece gerekli sütunları alalım
            model.addRow(new Object[]{abone[0], abone[1], abone[2]});
        }
    }

    // Variables declaration - do not modify
    private javax.swing.JTable AboneListesiTable;
    private javax.swing.JScrollPane AboneListesiTableScrollPane;
    private javax.swing.JButton AboneYonetimiBtn;
    private javax.swing.JPanel AboneYonetimiPanel;
    private javax.swing.JButton AboneYonetimiYeniAboneBtn;
    private javax.swing.JButton AnaSayfaBtn;
    private javax.swing.JLabel AnaSayfaKurumAboneSayisiLabel;
    private javax.swing.JLabel AnaSayfaKurumBakiyesiLabel;
    private javax.swing.JLabel AnaSayfaKurumBeklenenTahsilatLabel;
    private javax.swing.JPanel AnaSayfaPanel;
    private javax.swing.JTable FaturaAboneTable;
    private javax.swing.JScrollPane FaturaAboneTableScrollPane;
    private javax.swing.JButton FaturaOlusturBtn;
    private javax.swing.JLabel FaturaOlusturalacakKisiAdSoyadLabel;
    private javax.swing.JButton FaturaOlusturmaBtn;
    private javax.swing.JFrame FaturaOlusturmaFrame;
    private javax.swing.JPanel FaturaOlusturmaPanel;
    private javax.swing.JFormattedTextField FaturaSonTarihFTextF;
    private javax.swing.JTextField FaturaTutariTextF;
    private javax.swing.JButton FaturaYonetimiBtn;
    private javax.swing.JPanel FaturaYonetimiPanel;
    private javax.swing.JLabel KurumAdiLabel;
    private javax.swing.JLabel KurumKodLabel;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JPanel PanelContainer;
    private javax.swing.JPanel UstPanel;
    private javax.swing.JTextField YeniAboneAdTextF;
    private javax.swing.JTextField YeniAboneAylıkOdemeTutarTextF;
    private javax.swing.JTextField YeniAboneFaturaGünüTextF;
    private javax.swing.JFrame YeniAboneFrame;
    private javax.swing.JButton YeniAboneOlusturBtn;
    private javax.swing.JPanel YeniAbonePanel;
    private javax.swing.JTextField YeniAboneSoyadTextF;
    private javax.swing.JTextField YeniAboneTCTextF;
    private javax.swing.JPanel YonlendirmePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    // End of variables declaration
}

package UI;

public class BireyselKullaniciUI extends javax.swing.JFrame {

    // --- SINIF SEVİYESİ DEĞİŞKENLER (Global Variables) ---
    private model.IndividualUser aktifKullanici;
    private String seciliFaturaId = ""; // Ödenecek faturanın ID'sini tutar
    private double seciliFaturaTutari = 0.0;

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(BireyselKullaniciUI.class.getName());

    // --- CONSTRUCTOR (YAPICI METOT) ---
    public BireyselKullaniciUI(model.IndividualUser user) {
        this.aktifKullanici = user;
        initComponents();
        dovizInputlariniDuzenle();
        this.pack(); // Pencereyi içindeki elemanlara göre otomatik sığdırır (Taşmayı önler)
        this.setLocationRelativeTo(null); // Pencereyi tekrar ekranın ortasına alır

        // --- BUTON İKONLARI (32x32 Boyutunda Ayarlandı) ---
        AnaSayfaBtn.setIcon(IconHelper.createIcon("/resources/home.png", 32, 32));
        IslemlerBtn.setIcon(IconHelper.createIcon("/resources/transaction-history.png", 32, 32));
        HesaplarBtn.setIcon(IconHelper.createIcon("/resources/user.png", 32, 32));
        KartlarBtn.setIcon(IconHelper.createIcon("/resources/credit-card.png", 32, 32));
        FaturalarBtn.setIcon(IconHelper.createIcon("/resources/bill.png", 32, 32));
        VarliklarBtn.setIcon(IconHelper.createIcon("/resources/assets.png", 32, 32));
        GuncelKurBtn.setIcon(IconHelper.createIcon("/resources/exchange.png", 32, 32));
        UstPanelCıkısYapBtn.setIcon(IconHelper.createIcon("/resources/exit.png", 32, 32));

        UstPanelCıkısYapBtn.setContentAreaFilled(false);
        UstPanelCıkısYapBtn.setBorderPainted(false);
        UstPanelCıkısYapBtn.setFocusPainted(false);

        panelAdiLabel.setText("ANA SAYFA");

        // Verileri Veritabanından Çek ve Doldur
        if (aktifKullanici != null) {
            kullaniciBilgileriniGoster();
            anaSayfaGuncelle();
            hesaplariGuncelle();
            dovizKurlariniEkranaYaz();
            kartlariGuncelle();
            varliklariGuncelle();
            vadeliIslemBilgisiniGuncelle();
            guncelKurlariGuncelle();

            abonelikleriGuncelle(); // Abonelikler tablosunu doldur
            faturalariGuncelle();   // Faturalar tablosunu doldur
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        DolarIslemleri = new javax.swing.ButtonGroup();
        EuroIslemleri = new javax.swing.ButtonGroup();
        AltinIslemleri = new javax.swing.ButtonGroup();
        FaturaOdemeKartTuru = new javax.swing.ButtonGroup();
        KrediKartBorcOdeForm = new javax.swing.JFrame();
        KrediKartBorcOdePanel = new javax.swing.JPanel();
        KrediKartBorcGoruntulemeLabel = new javax.swing.JLabel();
        KrediKartBorcOdeFormBtn = new javax.swing.JButton();
        FaturaOdemeForm = new javax.swing.JFrame();
        FaturaOdemePanel = new javax.swing.JPanel();
        FaturaFirmaLabel = new javax.swing.JLabel();
        FaturaMiktariLabel = new javax.swing.JLabel();
        FaturaBankaKartOdeRdBtn = new javax.swing.JRadioButton();
        FaturaKrediKartOdeRdBtn = new javax.swing.JRadioButton();
        FaturaOdemeOdeBtn = new javax.swing.JButton();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        YonlendirmePanel = new javax.swing.JPanel();
        AnaSayfaBtn = new javax.swing.JButton();
        IslemlerBtn = new javax.swing.JButton();
        HesaplarBtn = new javax.swing.JButton();
        KartlarBtn = new javax.swing.JButton();
        FaturalarBtn = new javax.swing.JButton();
        VarliklarBtn = new javax.swing.JButton();
        GuncelKurBtn = new javax.swing.JButton();
        MainPanel = new javax.swing.JPanel();
        UstPanel = new javax.swing.JPanel();
        AdSoyadLabel = new javax.swing.JLabel();
        panelAdiLabel = new javax.swing.JLabel();
        lbl8 = new javax.swing.JLabel();
        MusteriNoLabel = new javax.swing.JLabel();
        UstPanelCıkısYapBtn = new javax.swing.JButton();
        PanelContainer = new javax.swing.JPanel();
        AnaSayfaPanel = new javax.swing.JPanel();
        AnaSayfaVadesizHesapPanel = new javax.swing.JPanel();
        lbl1 = new javax.swing.JLabel();
        AnaSayfaVadesizBakiyeLabel = new javax.swing.JLabel();
        AnaSayfaVadesizIBANLabel = new javax.swing.JLabel();
        AnaSayfaKrediKartiPanel = new javax.swing.JPanel();
        lbl2 = new javax.swing.JLabel();
        AnaSayfaKrdLimitLabel = new javax.swing.JLabel();
        AnaSayfaKrdKullanılabilirLimitLabel = new javax.swing.JLabel();
        AnaSayfaKrdBorcLabel = new javax.swing.JLabel();
        AnaSayfaBorcOdeBtn = new javax.swing.JButton();
        IslemlerPanel = new javax.swing.JPanel();
        IslemlerPanelContainer = new javax.swing.JPanel();
        IslParaGönderPanel = new javax.swing.JPanel();
        GonderilecekAdTextF = new javax.swing.JTextField();
        GonderilecekSoyadTextF = new javax.swing.JTextField();
        GonderilecekIBANTextF = new javax.swing.JTextField();
        GonderilecekMiktarTextF = new javax.swing.JTextField();
        GonderBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        IslVadeliPanel = new javax.swing.JPanel();
        IslVadeliBilgilendirmePanel = new javax.swing.JPanel();
        IslVadeliHesapBilgilendirmeLabel = new javax.swing.JLabel();
        IslVadeliVadeliHesapGormeBtn = new javax.swing.JButton();
        IslVadeliHesapAdlandirmaTextF = new javax.swing.JTextField();
        IslVadeSecenekleriComboBox = new javax.swing.JComboBox<>();
        IslVadeliBilgilendirmeLabel = new javax.swing.JLabel();
        IslVadeYatirilacakMiktarTextF = new javax.swing.JTextField();
        IslVadeliKazancLabel = new javax.swing.JLabel();
        IslVadeliHesapOnizle = new javax.swing.JButton();
        IslVadeliHesapOlustur = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        IslDovizPanel = new javax.swing.JPanel();
        lbl10 = new javax.swing.JLabel();
        lbl11 = new javax.swing.JLabel();
        lbl12 = new javax.swing.JLabel();
        IslDovizDolarAlısKur = new javax.swing.JLabel();
        IslDovizDolarSatısKur = new javax.swing.JLabel();
        IslDovizEuroAlısKur = new javax.swing.JLabel();
        IslDovizEuroSatısKur = new javax.swing.JLabel();
        IslDovizAltinAlısKur = new javax.swing.JLabel();
        IslDovizAltinSatisKur = new javax.swing.JLabel();
        IslAlınacakDolarMiktariTextF = new javax.swing.JTextField();
        IslSatilacakDolarMiktariTextF = new javax.swing.JTextField();
        IslAlınacakEuroMiktariTextF = new javax.swing.JTextField();
        IslSatilacakEuroMiktariTextF = new javax.swing.JTextField();
        IslAlınacakAltınMiktariTextF = new javax.swing.JTextField();
        IslSatılacakAlMiktariTextF = new javax.swing.JTextField();
        IslDovizDolarIslemi = new javax.swing.JButton();
        IslDovizEuroIslemi = new javax.swing.JButton();
        IslDovizAltinIslemi = new javax.swing.JButton();
        DolarAlRadioBtn = new javax.swing.JRadioButton();
        DolarSatRadioBtn = new javax.swing.JRadioButton();
        EuroAlRadioBtn = new javax.swing.JRadioButton();
        EuroSatRadioBtn = new javax.swing.JRadioButton();
        AltinAlRadioBtn = new javax.swing.JRadioButton();
        AltinSatRadioBtn = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        IslNakitAvansPanel = new javax.swing.JPanel();
        IslNakitAvansMiktariTextF = new javax.swing.JTextField();
        IslNakitAvansGonderBtn = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        IslParaGönderBtn = new javax.swing.JButton();
        IslVadeliBtn = new javax.swing.JButton();
        IslDovizBtn = new javax.swing.JButton();
        IslNakitAvansPanelBtn = new javax.swing.JButton();
        HesaplarPanel = new javax.swing.JPanel();
        HesaplarPanelContainer = new javax.swing.JPanel();
        HspVadesizPanel = new javax.swing.JPanel();
        HspVadesizBakiyeLbl = new javax.swing.JLabel();
        HspVadesizIBANLbl = new javax.swing.JLabel();
        HspVadesizParaTrnsfrBtn = new javax.swing.JButton();
        HspVadesizFaturaOdeBtn = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        HspVadeliPanel = new javax.swing.JPanel();
        HspVadeliVarPanel = new javax.swing.JPanel();
        HspVadeliListComboBox = new javax.swing.JComboBox<>();
        HspVadeliTürüLbl = new javax.swing.JLabel();
        HspVadeliYatirilanTutarLbl = new javax.swing.JLabel();
        HspVadeliKalanGunLbl = new javax.swing.JLabel();
        HspVadeliKalanGetirisiLbl = new javax.swing.JLabel();
        HspVadeliYeniHesapBtn = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        HspVadeliYokPanel = new javax.swing.JPanel();
        lbl9 = new javax.swing.JLabel();
        HspVadeliAcBtn = new javax.swing.JButton();
        HspDovizPanel = new javax.swing.JPanel();
        HspDovizDolarBakiyeLabel = new javax.swing.JLabel();
        HspDovizEuroBakiyeLabel = new javax.swing.JLabel();
        HspDovizAltınBakiyeLabel = new javax.swing.JLabel();
        HspDovizDolarTLLabel = new javax.swing.JLabel();
        HspDovizEuroTLLabel = new javax.swing.JLabel();
        HspDovizAltınTLLabel = new javax.swing.JLabel();
        HspDovizIslemleriBtn = new javax.swing.JButton();
        label12 = new javax.swing.JLabel();
        label13 = new javax.swing.JLabel();
        label14 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        HspVadesizBtn = new javax.swing.JButton();
        HspVadeliBtn = new javax.swing.JButton();
        HspDövizBtn = new javax.swing.JButton();
        KartlarPanel = new javax.swing.JPanel();
        KrtBankaKartiPanel = new javax.swing.JPanel();
        lbl6 = new javax.swing.JLabel();
        BankaKartNoLabel = new javax.swing.JLabel();
        BankaKartCVVLabel = new javax.swing.JLabel();
        BankaKartSKTLabel = new javax.swing.JLabel();
        BankaKartAdSoyadLabel = new javax.swing.JLabel();
        BankaKartBakiye = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        KrtKrediKartiPanel = new javax.swing.JPanel();
        lbl7 = new javax.swing.JLabel();
        KrediKartNoLabel = new javax.swing.JLabel();
        KrediKartCVVLabel = new javax.swing.JLabel();
        KrediKartSKTLabel = new javax.swing.JLabel();
        KrediKartAdSoyadLabel = new javax.swing.JLabel();
        KrediKartLimitLabel = new javax.swing.JLabel();
        KrediKartKullanılabilirBakiyeLabel = new javax.swing.JLabel();
        KrediKartBorcLabel = new javax.swing.JLabel();
        KrediKartBorcOdeBtn = new javax.swing.JButton();
        KrediKartNakitAvansBtn = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        FaturalarPanel = new javax.swing.JPanel();
        FtrAboneliklerimBtn = new javax.swing.JButton();
        FtrFaturalarımBtn = new javax.swing.JButton();
        FaturalarPanelContainer = new javax.swing.JPanel();
        FtrAboneliklerimPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        FtrAboneliklerimTable = new javax.swing.JTable();
        FtrFaturalarımPanel = new javax.swing.JPanel();
        FtrFaturalarimTables = new javax.swing.JScrollPane();
        FtrFaturalarimTable = new javax.swing.JTable();
        FaturaOdeBtn = new javax.swing.JButton();
        VarliklarPanel = new javax.swing.JPanel();
        VarliklarTLLabel = new javax.swing.JLabel();
        VarliklarDolarLabel = new javax.swing.JLabel();
        VarliklarEuroLabel = new javax.swing.JLabel();
        VarliklarAltinLabel = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        GuncelKurPanel = new javax.swing.JPanel();
        GuncelKurDolarAlısLabel = new javax.swing.JLabel();
        GuncelKurDolarSatısLabel = new javax.swing.JLabel();
        GuncelKurEuroAlısLabel = new javax.swing.JLabel();
        GuncelKurEuroSatisLabel = new javax.swing.JLabel();
        GuncelKurAltinAlısLabel = new javax.swing.JLabel();
        GuncelKurAltinSatisLabel = new javax.swing.JLabel();
        GuncelKurDovizIslemleriYonlendirmeBtn = new javax.swing.JButton();

        KrediKartBorcGoruntulemeLabel.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        KrediKartBorcGoruntulemeLabel.setText("Kart Borcunuz");

        KrediKartBorcOdeFormBtn.setBackground(new java.awt.Color(0, 102, 102));
        KrediKartBorcOdeFormBtn.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        KrediKartBorcOdeFormBtn.setText("Öde");
        KrediKartBorcOdeFormBtn.addActionListener(this::KrediKartBorcOdeFormBtnActionPerformed);

        javax.swing.GroupLayout KrediKartBorcOdePanelLayout = new javax.swing.GroupLayout(KrediKartBorcOdePanel);
        KrediKartBorcOdePanel.setLayout(KrediKartBorcOdePanelLayout);
        KrediKartBorcOdePanelLayout.setHorizontalGroup(
                KrediKartBorcOdePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(KrediKartBorcOdePanelLayout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addGroup(KrediKartBorcOdePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(KrediKartBorcOdeFormBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(KrediKartBorcGoruntulemeLabel))
                                .addContainerGap(85, Short.MAX_VALUE))
        );
        KrediKartBorcOdePanelLayout.setVerticalGroup(
                KrediKartBorcOdePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(KrediKartBorcOdePanelLayout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(KrediKartBorcGoruntulemeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                                .addComponent(KrediKartBorcOdeFormBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(91, 91, 91))
        );

        javax.swing.GroupLayout KrediKartBorcOdeFormLayout = new javax.swing.GroupLayout(KrediKartBorcOdeForm.getContentPane());
        KrediKartBorcOdeForm.getContentPane().setLayout(KrediKartBorcOdeFormLayout);
        KrediKartBorcOdeFormLayout.setHorizontalGroup(
                KrediKartBorcOdeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(KrediKartBorcOdePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        KrediKartBorcOdeFormLayout.setVerticalGroup(
                KrediKartBorcOdeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(KrediKartBorcOdePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        FaturaFirmaLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        FaturaFirmaLabel.setText("jLabel43");

        FaturaMiktariLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        FaturaMiktariLabel.setText("jLabel43");

        FaturaOdemeKartTuru.add(FaturaBankaKartOdeRdBtn);
        FaturaBankaKartOdeRdBtn.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        FaturaBankaKartOdeRdBtn.setText("Banka Kartı");

        FaturaOdemeKartTuru.add(FaturaKrediKartOdeRdBtn);
        FaturaKrediKartOdeRdBtn.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        FaturaKrediKartOdeRdBtn.setText("Kredi Kartı");

        FaturaOdemeOdeBtn.setBackground(new java.awt.Color(0, 102, 102));
        FaturaOdemeOdeBtn.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        FaturaOdemeOdeBtn.setText("Fatura Öde");
        FaturaOdemeOdeBtn.addActionListener(this::FaturaOdemeOdeBtnActionPerformed);

        jLabel43.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel43.setText("Firma");

        jLabel44.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel44.setText("Tutar");

        javax.swing.GroupLayout FaturaOdemePanelLayout = new javax.swing.GroupLayout(FaturaOdemePanel);
        FaturaOdemePanel.setLayout(FaturaOdemePanelLayout);
        FaturaOdemePanelLayout.setHorizontalGroup(
                FaturaOdemePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(FaturaOdemePanelLayout.createSequentialGroup()
                                .addGroup(FaturaOdemePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(FaturaOdemePanelLayout.createSequentialGroup()
                                                .addGap(80, 80, 80)
                                                .addGroup(FaturaOdemePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(FaturaKrediKartOdeRdBtn)
                                                        .addComponent(FaturaBankaKartOdeRdBtn)))
                                        .addGroup(FaturaOdemePanelLayout.createSequentialGroup()
                                                .addGap(85, 85, 85)
                                                .addGroup(FaturaOdemePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel44)
                                                        .addComponent(jLabel43))
                                                .addGap(31, 31, 31)
                                                .addGroup(FaturaOdemePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(FaturaFirmaLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(FaturaMiktariLabel, javax.swing.GroupLayout.Alignment.TRAILING)))
                                        .addGroup(FaturaOdemePanelLayout.createSequentialGroup()
                                                .addGap(70, 70, 70)
                                                .addComponent(FaturaOdemeOdeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(82, Short.MAX_VALUE))
        );
        FaturaOdemePanelLayout.setVerticalGroup(
                FaturaOdemePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(FaturaOdemePanelLayout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addGroup(FaturaOdemePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(FaturaFirmaLabel)
                                        .addComponent(jLabel43))
                                .addGap(18, 18, 18)
                                .addGroup(FaturaOdemePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(FaturaMiktariLabel)
                                        .addComponent(jLabel44))
                                .addGap(39, 39, 39)
                                .addComponent(FaturaBankaKartOdeRdBtn)
                                .addGap(18, 18, 18)
                                .addComponent(FaturaKrediKartOdeRdBtn)
                                .addGap(37, 37, 37)
                                .addComponent(FaturaOdemeOdeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(76, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout FaturaOdemeFormLayout = new javax.swing.GroupLayout(FaturaOdemeForm.getContentPane());
        FaturaOdemeForm.getContentPane().setLayout(FaturaOdemeFormLayout);
        FaturaOdemeFormLayout.setHorizontalGroup(
                FaturaOdemeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(FaturaOdemePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        FaturaOdemeFormLayout.setVerticalGroup(
                FaturaOdemeFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(FaturaOdemePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        AnaSayfaBtn.setBackground(new java.awt.Color(0, 102, 153));
        AnaSayfaBtn.addActionListener(this::AnaSayfaBtnActionPerformed);

        IslemlerBtn.setBackground(new java.awt.Color(0, 102, 153));
        IslemlerBtn.addActionListener(this::IslemlerBtnActionPerformed);

        HesaplarBtn.setBackground(new java.awt.Color(0, 102, 153));
        HesaplarBtn.addActionListener(this::HesaplarBtnActionPerformed);

        KartlarBtn.setBackground(new java.awt.Color(0, 102, 153));
        KartlarBtn.addActionListener(this::KartlarBtnActionPerformed);

        FaturalarBtn.setBackground(new java.awt.Color(0, 102, 153));
        FaturalarBtn.addActionListener(this::FaturalarBtnActionPerformed);

        VarliklarBtn.setBackground(new java.awt.Color(0, 102, 153));
        VarliklarBtn.addActionListener(this::VarliklarBtnActionPerformed);

        GuncelKurBtn.setBackground(new java.awt.Color(0, 102, 153));
        GuncelKurBtn.addActionListener(this::GuncelKurBtnActionPerformed);

        javax.swing.GroupLayout YonlendirmePanelLayout = new javax.swing.GroupLayout(YonlendirmePanel);
        YonlendirmePanel.setLayout(YonlendirmePanelLayout);
        YonlendirmePanelLayout.setHorizontalGroup(
                YonlendirmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(YonlendirmePanelLayout.createSequentialGroup()
                                .addGap(327, 327, 327)
                                .addComponent(AnaSayfaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IslemlerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(HesaplarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(KartlarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FaturalarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(VarliklarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(GuncelKurBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        YonlendirmePanelLayout.setVerticalGroup(
                YonlendirmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(YonlendirmePanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(YonlendirmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(AnaSayfaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(IslemlerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(HesaplarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(KartlarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(FaturalarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(VarliklarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(GuncelKurBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        UstPanel.setBackground(new java.awt.Color(0, 102, 255));

        AdSoyadLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        AdSoyadLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AdSoyadLabel.setText("Ad Soyad");

        panelAdiLabel.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        panelAdiLabel.setText("panelAdi");

        lbl8.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        lbl8.setText("DİNO BANK");

        MusteriNoLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        MusteriNoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MusteriNoLabel.setText("MusteriNo");

        UstPanelCıkısYapBtn.setBackground(new java.awt.Color(0, 102, 102));
        UstPanelCıkısYapBtn.addActionListener(this::UstPanelCıkısYapBtnActionPerformed);

        javax.swing.GroupLayout UstPanelLayout = new javax.swing.GroupLayout(UstPanel);
        UstPanel.setLayout(UstPanelLayout);
        UstPanelLayout.setHorizontalGroup(
                UstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(UstPanelLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(UstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(AdSoyadLabel)
                                        .addComponent(MusteriNoLabel))
                                .addGap(384, 384, 384)
                                .addGroup(UstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbl8)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UstPanelLayout.createSequentialGroup()
                                                .addComponent(panelAdiLabel)
                                                .addGap(31, 31, 31)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(UstPanelCıkısYapBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24))
        );
        UstPanelLayout.setVerticalGroup(
                UstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(UstPanelLayout.createSequentialGroup()
                                .addGroup(UstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(UstPanelLayout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addGroup(UstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(UstPanelLayout.createSequentialGroup()
                                                                .addComponent(lbl8)
                                                                .addGap(20, 20, 20)
                                                                .addComponent(panelAdiLabel))
                                                        .addGroup(UstPanelLayout.createSequentialGroup()
                                                                .addComponent(AdSoyadLabel)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(MusteriNoLabel))))
                                        .addGroup(UstPanelLayout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addComponent(UstPanelCıkısYapBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelContainer.setLayout(new java.awt.CardLayout());

        AnaSayfaVadesizHesapPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbl1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        lbl1.setText("Vadesiz Hesap");

        AnaSayfaVadesizBakiyeLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        AnaSayfaVadesizBakiyeLabel.setText("Bakiye");

        AnaSayfaVadesizIBANLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        AnaSayfaVadesizIBANLabel.setText("Iban");

        javax.swing.GroupLayout AnaSayfaVadesizHesapPanelLayout = new javax.swing.GroupLayout(AnaSayfaVadesizHesapPanel);
        AnaSayfaVadesizHesapPanel.setLayout(AnaSayfaVadesizHesapPanelLayout);
        AnaSayfaVadesizHesapPanelLayout.setHorizontalGroup(
                AnaSayfaVadesizHesapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(AnaSayfaVadesizHesapPanelLayout.createSequentialGroup()
                                .addGroup(AnaSayfaVadesizHesapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(AnaSayfaVadesizHesapPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(lbl1))
                                        .addGroup(AnaSayfaVadesizHesapPanelLayout.createSequentialGroup()
                                                .addGap(63, 63, 63)
                                                .addComponent(AnaSayfaVadesizBakiyeLabel))
                                        .addGroup(AnaSayfaVadesizHesapPanelLayout.createSequentialGroup()
                                                .addGap(63, 63, 63)
                                                .addComponent(AnaSayfaVadesizIBANLabel)))
                                .addContainerGap(709, Short.MAX_VALUE))
        );
        AnaSayfaVadesizHesapPanelLayout.setVerticalGroup(
                AnaSayfaVadesizHesapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(AnaSayfaVadesizHesapPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbl1)
                                .addGap(46, 46, 46)
                                .addComponent(AnaSayfaVadesizBakiyeLabel)
                                .addGap(28, 28, 28)
                                .addComponent(AnaSayfaVadesizIBANLabel)
                                .addContainerGap(101, Short.MAX_VALUE))
        );

        AnaSayfaKrediKartiPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbl2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        lbl2.setText("Kredi Kartı");

        AnaSayfaKrdLimitLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        AnaSayfaKrdLimitLabel.setText("Kart Limit");

        AnaSayfaKrdKullanılabilirLimitLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        AnaSayfaKrdKullanılabilirLimitLabel.setText("Kullanılabilir Limit");

        AnaSayfaKrdBorcLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        AnaSayfaKrdBorcLabel.setText("Güncel Borç");

        AnaSayfaBorcOdeBtn.setBackground(new java.awt.Color(0, 102, 153));
        AnaSayfaBorcOdeBtn.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        AnaSayfaBorcOdeBtn.setText("Borç Öde");
        AnaSayfaBorcOdeBtn.setAlignmentY(0.0F);
        AnaSayfaBorcOdeBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        AnaSayfaBorcOdeBtn.addActionListener(this::AnaSayfaBorcOdeBtnActionPerformed);

        javax.swing.GroupLayout AnaSayfaKrediKartiPanelLayout = new javax.swing.GroupLayout(AnaSayfaKrediKartiPanel);
        AnaSayfaKrediKartiPanel.setLayout(AnaSayfaKrediKartiPanelLayout);
        AnaSayfaKrediKartiPanelLayout.setHorizontalGroup(
                AnaSayfaKrediKartiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(AnaSayfaKrediKartiPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbl2)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(AnaSayfaKrediKartiPanelLayout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addGroup(AnaSayfaKrediKartiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(AnaSayfaKrdLimitLabel)
                                        .addComponent(AnaSayfaKrdKullanılabilirLimitLabel)
                                        .addComponent(AnaSayfaKrdBorcLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(AnaSayfaBorcOdeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(89, 89, 89))
        );
        AnaSayfaKrediKartiPanelLayout.setVerticalGroup(
                AnaSayfaKrediKartiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(AnaSayfaKrediKartiPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbl2)
                                .addGap(18, 18, 18)
                                .addGroup(AnaSayfaKrediKartiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(AnaSayfaKrediKartiPanelLayout.createSequentialGroup()
                                                .addComponent(AnaSayfaKrdLimitLabel)
                                                .addGap(18, 18, 18)
                                                .addComponent(AnaSayfaKrdKullanılabilirLimitLabel))
                                        .addComponent(AnaSayfaBorcOdeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(AnaSayfaKrdBorcLabel)
                                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout AnaSayfaPanelLayout = new javax.swing.GroupLayout(AnaSayfaPanel);
        AnaSayfaPanel.setLayout(AnaSayfaPanelLayout);
        AnaSayfaPanelLayout.setHorizontalGroup(
                AnaSayfaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AnaSayfaPanelLayout.createSequentialGroup()
                                .addContainerGap(232, Short.MAX_VALUE)
                                .addGroup(AnaSayfaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(AnaSayfaKrediKartiPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(AnaSayfaVadesizHesapPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(92, 92, 92))
        );
        AnaSayfaPanelLayout.setVerticalGroup(
                AnaSayfaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(AnaSayfaPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(AnaSayfaVadesizHesapPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(AnaSayfaKrediKartiPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelContainer.add(AnaSayfaPanel, "cardAnaSayfaPanel");

        IslemlerPanelContainer.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        IslemlerPanelContainer.setLayout(new java.awt.CardLayout());

        GonderilecekAdTextF.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        GonderilecekSoyadTextF.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        GonderilecekIBANTextF.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        GonderilecekMiktarTextF.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        GonderBtn.setBackground(new java.awt.Color(0, 102, 153));
        GonderBtn.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        GonderBtn.setText("Gönder");
        GonderBtn.addActionListener(this::GonderBtnActionPerformed);

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel1.setText("Gönderilecek Kullanıcının Adı:");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel2.setText("Gönderilecek Kullanıcının Soyadı:");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel3.setText("Gönderilecek Kullanıcının IBAN'ı:");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel4.setText("Gönderilecek Tutar:");

        javax.swing.GroupLayout IslParaGönderPanelLayout = new javax.swing.GroupLayout(IslParaGönderPanel);
        IslParaGönderPanel.setLayout(IslParaGönderPanelLayout);
        IslParaGönderPanelLayout.setHorizontalGroup(
                IslParaGönderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(IslParaGönderPanelLayout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addGroup(IslParaGönderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(IslParaGönderPanelLayout.createSequentialGroup()
                                                .addGroup(IslParaGönderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(IslParaGönderPanelLayout.createSequentialGroup()
                                                                .addGap(3, 3, 3)
                                                                .addGroup(IslParaGönderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(IslParaGönderPanelLayout.createSequentialGroup()
                                                                                .addGap(92, 92, 92)
                                                                                .addComponent(jLabel4)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(GonderilecekMiktarTextF, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                                                                        .addGroup(IslParaGönderPanelLayout.createSequentialGroup()
                                                                                .addComponent(jLabel3)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(GonderilecekIBANTextF))))
                                                        .addGroup(IslParaGönderPanelLayout.createSequentialGroup()
                                                                .addComponent(jLabel2)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(GonderilecekSoyadTextF)))
                                                .addGap(56, 56, 56)
                                                .addComponent(GonderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(80, 80, 80))
                                        .addGroup(IslParaGönderPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(18, 18, 18)
                                                .addComponent(GonderilecekAdTextF, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(273, 273, 273))))
        );
        IslParaGönderPanelLayout.setVerticalGroup(
                IslParaGönderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(IslParaGönderPanelLayout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addGroup(IslParaGönderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(GonderilecekAdTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addGroup(IslParaGönderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(IslParaGönderPanelLayout.createSequentialGroup()
                                                .addGap(43, 43, 43)
                                                .addGroup(IslParaGönderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(GonderilecekSoyadTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel2))
                                                .addGap(48, 48, 48)
                                                .addGroup(IslParaGönderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel3)
                                                        .addComponent(GonderilecekIBANTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(IslParaGönderPanelLayout.createSequentialGroup()
                                                .addGap(67, 67, 67)
                                                .addComponent(GonderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(37, 37, 37)
                                .addGroup(IslParaGönderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(GonderilecekMiktarTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                .addContainerGap(135, Short.MAX_VALUE))
        );

        IslemlerPanelContainer.add(IslParaGönderPanel, "cardIslParaGönderPanel");

        IslVadeliBilgilendirmePanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        IslVadeliHesapBilgilendirmeLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        IslVadeliHesapBilgilendirmeLabel.setText("vadeli hesabınız bilgi");

        IslVadeliVadeliHesapGormeBtn.setBackground(new java.awt.Color(0, 102, 153));
        IslVadeliVadeliHesapGormeBtn.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        IslVadeliVadeliHesapGormeBtn.setText("Vadeli Hesaplarım");
        IslVadeliVadeliHesapGormeBtn.addActionListener(this::IslVadeliVadeliHesapGormeBtnActionPerformed);

        javax.swing.GroupLayout IslVadeliBilgilendirmePanelLayout = new javax.swing.GroupLayout(IslVadeliBilgilendirmePanel);
        IslVadeliBilgilendirmePanel.setLayout(IslVadeliBilgilendirmePanelLayout);
        IslVadeliBilgilendirmePanelLayout.setHorizontalGroup(
                IslVadeliBilgilendirmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(IslVadeliBilgilendirmePanelLayout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(IslVadeliHesapBilgilendirmeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 340, Short.MAX_VALUE)
                                .addComponent(IslVadeliVadeliHesapGormeBtn)
                                .addGap(25, 25, 25))
        );
        IslVadeliBilgilendirmePanelLayout.setVerticalGroup(
                IslVadeliBilgilendirmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(IslVadeliBilgilendirmePanelLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(IslVadeliBilgilendirmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(IslVadeliHesapBilgilendirmeLabel)
                                        .addComponent(IslVadeliVadeliHesapGormeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(50, Short.MAX_VALUE))
        );

        IslVadeliHesapAdlandirmaTextF.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        IslVadeSecenekleriComboBox.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        IslVadeSecenekleriComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kısa (32 Gün) - %40 Faiz", "Orta (92 Gün) - %45 Faiz", "Uzun (181 Gün) - %48 Faiz", "Yıllık (365 Gün) - %50 Faiz" }));

        IslVadeliBilgilendirmeLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        IslVadeliBilgilendirmeLabel.setText("          ");

        IslVadeYatirilacakMiktarTextF.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        IslVadeliKazancLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        IslVadeliKazancLabel.setText("           ");

        IslVadeliHesapOnizle.setBackground(new java.awt.Color(0, 102, 153));
        IslVadeliHesapOnizle.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        IslVadeliHesapOnizle.setText("Önizle");
        IslVadeliHesapOnizle.addActionListener(this::IslVadeliHesapOnizleActionPerformed);

        IslVadeliHesapOlustur.setBackground(new java.awt.Color(0, 102, 153));
        IslVadeliHesapOlustur.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        IslVadeliHesapOlustur.setText("Vadeli Hesabı Oluştur");
        IslVadeliHesapOlustur.addActionListener(this::IslVadeliHesapOlusturActionPerformed);

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel5.setText("Vadeli Hesap Adı:");

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel6.setText("Yatırılacak Miktar:");

        javax.swing.GroupLayout IslVadeliPanelLayout = new javax.swing.GroupLayout(IslVadeliPanel);
        IslVadeliPanel.setLayout(IslVadeliPanelLayout);
        IslVadeliPanelLayout.setHorizontalGroup(
                IslVadeliPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(IslVadeliPanelLayout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(IslVadeliBilgilendirmePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(15, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, IslVadeliPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(IslVadeliPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, IslVadeliPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(IslVadeliPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(IslVadeliBilgilendirmeLabel)
                                                        .addComponent(IslVadeliHesapAdlandirmaTextF, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, IslVadeliPanelLayout.createSequentialGroup()
                                                .addGroup(IslVadeliPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(IslVadeliPanelLayout.createSequentialGroup()
                                                                .addComponent(IslVadeSecenekleriComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, IslVadeliPanelLayout.createSequentialGroup()
                                                                .addGroup(IslVadeliPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(IslVadeliKazancLabel)
                                                                        .addComponent(jLabel6))
                                                                .addGap(8, 8, 8)
                                                                .addComponent(IslVadeYatirilacakMiktarTextF, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(43, 43, 43)))
                                .addGroup(IslVadeliPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(IslVadeliPanelLayout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addComponent(IslVadeliHesapOlustur)
                                                .addGap(53, 53, 53))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, IslVadeliPanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(IslVadeliHesapOnizle, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(68, 68, 68))))
        );
        IslVadeliPanelLayout.setVerticalGroup(
                IslVadeliPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(IslVadeliPanelLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(IslVadeliBilgilendirmePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addGroup(IslVadeliPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(IslVadeliHesapAdlandirmaTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5))
                                .addGroup(IslVadeliPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(IslVadeliPanelLayout.createSequentialGroup()
                                                .addGap(38, 38, 38)
                                                .addComponent(IslVadeliHesapOnizle, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(IslVadeliHesapOlustur, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(IslVadeliPanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(IslVadeliBilgilendirmeLabel)
                                                .addGap(15, 15, 15)
                                                .addComponent(IslVadeSecenekleriComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(IslVadeliKazancLabel)
                                                .addGap(8, 8, 8)
                                                .addGroup(IslVadeliPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(IslVadeYatirilacakMiktarTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel6))))
                                .addContainerGap(68, Short.MAX_VALUE))
        );

        IslemlerPanelContainer.add(IslVadeliPanel, "cardIslVadeliPanel");

        lbl10.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        lbl10.setText("Dolar");

        lbl11.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        lbl11.setText("Euro");

        lbl12.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        lbl12.setText("Altın");

        IslDovizDolarAlısKur.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        IslDovizDolarAlısKur.setText("DolarAlışKur");

        IslDovizDolarSatısKur.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        IslDovizDolarSatısKur.setText("Dolar SatışKur");

        IslDovizEuroAlısKur.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        IslDovizEuroAlısKur.setText("EuroAlışKur");

        IslDovizEuroSatısKur.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        IslDovizEuroSatısKur.setText("EuroSatışKur");

        IslDovizAltinAlısKur.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        IslDovizAltinAlısKur.setText("AltınAlışKur");

        IslDovizAltinSatisKur.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        IslDovizAltinSatisKur.setText("AltınSatışKur");

        IslAlınacakDolarMiktariTextF.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        IslSatilacakDolarMiktariTextF.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        IslAlınacakEuroMiktariTextF.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        IslSatilacakEuroMiktariTextF.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        IslAlınacakAltınMiktariTextF.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        IslSatılacakAlMiktariTextF.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        IslDovizDolarIslemi.setBackground(new java.awt.Color(0, 102, 0));
        IslDovizDolarIslemi.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        IslDovizDolarIslemi.setText("Dolar İşlemi");
        IslDovizDolarIslemi.addActionListener(this::IslDovizDolarIslemiActionPerformed);

        IslDovizEuroIslemi.setBackground(new java.awt.Color(0, 102, 102));
        IslDovizEuroIslemi.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        IslDovizEuroIslemi.setText("Euro İşlemi");
        IslDovizEuroIslemi.addActionListener(this::IslDovizEuroIslemiActionPerformed);

        IslDovizAltinIslemi.setBackground(new java.awt.Color(102, 102, 0));
        IslDovizAltinIslemi.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        IslDovizAltinIslemi.setText("Altın İşlemi");
        IslDovizAltinIslemi.addActionListener(this::IslDovizAltinIslemiActionPerformed);

        DolarIslemleri.add(DolarAlRadioBtn);
        DolarAlRadioBtn.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        DolarAlRadioBtn.setText("Dolar Al");

        DolarIslemleri.add(DolarSatRadioBtn);
        DolarSatRadioBtn.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        DolarSatRadioBtn.setText("Dolar Sat");

        EuroIslemleri.add(EuroAlRadioBtn);
        EuroAlRadioBtn.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        EuroAlRadioBtn.setText("Euro Al");

        EuroIslemleri.add(EuroSatRadioBtn);
        EuroSatRadioBtn.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        EuroSatRadioBtn.setText("Euro Sat");

        AltinIslemleri.add(AltinAlRadioBtn);
        AltinAlRadioBtn.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        AltinAlRadioBtn.setText("Altın Al");

        AltinIslemleri.add(AltinSatRadioBtn);
        AltinSatRadioBtn.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        AltinSatRadioBtn.setText("Altın Sat");

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel7.setText("Al");

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel8.setText("Sat");

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel9.setText("Al");

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel10.setText("Sat");

        jLabel11.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel11.setText("Sat");

        jLabel12.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel12.setText("Al");

        jLabel13.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel13.setText("Dolar Alış:");

        jLabel14.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel14.setText("Dolar Satış:");

        jLabel15.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel15.setText("Euro Alış:");

        jLabel16.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel16.setText("Euro Satış:");

        jLabel17.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel17.setText("Altın Alış:");

        jLabel18.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel18.setText("Altın Satış:");

        javax.swing.GroupLayout IslDovizPanelLayout = new javax.swing.GroupLayout(IslDovizPanel);
        IslDovizPanel.setLayout(IslDovizPanelLayout);
        IslDovizPanelLayout.setHorizontalGroup(
                IslDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(IslDovizPanelLayout.createSequentialGroup()
                                .addGroup(IslDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(IslDovizPanelLayout.createSequentialGroup()
                                                .addGap(84, 84, 84)
                                                .addComponent(IslDovizDolarIslemi))
                                        .addGroup(IslDovizPanelLayout.createSequentialGroup()
                                                .addGap(56, 56, 56)
                                                .addGroup(IslDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel13)
                                                        .addComponent(jLabel14))
                                                .addGroup(IslDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(IslDovizPanelLayout.createSequentialGroup()
                                                                .addGap(14, 14, 14)
                                                                .addComponent(IslDovizDolarAlısKur))
                                                        .addGroup(IslDovizPanelLayout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(IslDovizDolarSatısKur)))
                                                .addGap(49, 49, 49)
                                                .addGroup(IslDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(IslDovizPanelLayout.createSequentialGroup()
                                                                .addComponent(jLabel15)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(IslDovizEuroAlısKur))
                                                        .addGroup(IslDovizPanelLayout.createSequentialGroup()
                                                                .addGroup(IslDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addGroup(IslDovizPanelLayout.createSequentialGroup()
                                                                                .addGap(255, 255, 255)
                                                                                .addComponent(jLabel17))
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, IslDovizPanelLayout.createSequentialGroup()
                                                                                .addComponent(jLabel16)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(IslDovizEuroSatısKur)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(jLabel18)))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(IslDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(IslDovizAltinAlısKur)
                                                                        .addComponent(IslDovizAltinSatisKur)))))
                                        .addGroup(IslDovizPanelLayout.createSequentialGroup()
                                                .addGroup(IslDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(IslDovizPanelLayout.createSequentialGroup()
                                                                .addGap(93, 93, 93)
                                                                .addGroup(IslDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addGroup(IslDovizPanelLayout.createSequentialGroup()
                                                                                .addComponent(jLabel8)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(IslSatilacakDolarMiktariTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(IslDovizPanelLayout.createSequentialGroup()
                                                                                .addComponent(jLabel7)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(IslAlınacakDolarMiktariTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(IslDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(DolarAlRadioBtn)
                                                                                .addComponent(DolarSatRadioBtn)))
                                                                .addGap(127, 127, 127)
                                                                .addGroup(IslDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addGroup(IslDovizPanelLayout.createSequentialGroup()
                                                                                .addComponent(jLabel10)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addGroup(IslDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(IslSatilacakEuroMiktariTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(EuroSatRadioBtn)
                                                                                        .addComponent(EuroAlRadioBtn)))
                                                                        .addGroup(IslDovizPanelLayout.createSequentialGroup()
                                                                                .addComponent(jLabel9)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(IslAlınacakEuroMiktariTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)))
                                                                .addGap(142, 142, 142))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, IslDovizPanelLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(IslDovizEuroIslemi, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(119, 119, 119)))
                                                .addGroup(IslDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(IslDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, IslDovizPanelLayout.createSequentialGroup()
                                                                        .addComponent(jLabel12)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(IslAlınacakAltınMiktariTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, IslDovizPanelLayout.createSequentialGroup()
                                                                        .addGroup(IslDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addGroup(IslDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(AltinAlRadioBtn)
                                                                                        .addComponent(AltinSatRadioBtn))
                                                                                .addGroup(IslDovizPanelLayout.createSequentialGroup()
                                                                                        .addComponent(jLabel11)
                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addComponent(IslSatılacakAlMiktariTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                        .addGap(1, 1, 1)))
                                                        .addComponent(IslDovizAltinIslemi, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(69, Short.MAX_VALUE))
                        .addGroup(IslDovizPanelLayout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(lbl10)
                                .addGap(184, 184, 184)
                                .addComponent(lbl11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl12)
                                .addGap(137, 137, 137))
        );
        IslDovizPanelLayout.setVerticalGroup(
                IslDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(IslDovizPanelLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(IslDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, IslDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(lbl10)
                                                .addComponent(lbl11))
                                        .addComponent(lbl12, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(IslDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(IslDovizPanelLayout.createSequentialGroup()
                                                .addGroup(IslDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(IslAlınacakAltınMiktariTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel12))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(IslDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(IslSatılacakAlMiktariTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel11))
                                                .addGap(18, 18, 18)
                                                .addComponent(AltinAlRadioBtn)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(AltinSatRadioBtn))
                                        .addGroup(IslDovizPanelLayout.createSequentialGroup()
                                                .addGroup(IslDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(IslAlınacakDolarMiktariTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel7))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(IslDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(IslSatilacakDolarMiktariTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel8))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(DolarAlRadioBtn)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(DolarSatRadioBtn))
                                        .addGroup(IslDovizPanelLayout.createSequentialGroup()
                                                .addGroup(IslDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(IslAlınacakEuroMiktariTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel9))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(IslDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(IslSatilacakEuroMiktariTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel10))
                                                .addGap(18, 18, 18)
                                                .addComponent(EuroAlRadioBtn)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(EuroSatRadioBtn)))
                                .addGap(18, 18, 18)
                                .addGroup(IslDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(IslDovizEuroIslemi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(IslDovizAltinIslemi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(IslDovizDolarIslemi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(IslDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(IslDovizPanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                                                .addGroup(IslDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel15)
                                                        .addComponent(IslDovizEuroAlısKur)
                                                        .addComponent(jLabel17)
                                                        .addComponent(IslDovizAltinAlısKur))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(IslDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel16)
                                                        .addComponent(IslDovizEuroSatısKur)
                                                        .addComponent(jLabel18)
                                                        .addComponent(IslDovizAltinSatisKur))
                                                .addGap(113, 113, 113))
                                        .addGroup(IslDovizPanelLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(IslDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel13)
                                                        .addComponent(IslDovizDolarAlısKur))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(IslDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel14)
                                                        .addComponent(IslDovizDolarSatısKur))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        IslemlerPanelContainer.add(IslDovizPanel, "cardIslDovizPanel");

        IslNakitAvansMiktariTextF.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N

        IslNakitAvansGonderBtn.setBackground(new java.awt.Color(0, 102, 153));
        IslNakitAvansGonderBtn.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        IslNakitAvansGonderBtn.setText("Nakit Avans Gönder");
        IslNakitAvansGonderBtn.addActionListener(this::IslNakitAvansGonderBtnActionPerformed);

        jLabel19.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel19.setText("Gönderilecek Nakit Avans:");

        javax.swing.GroupLayout IslNakitAvansPanelLayout = new javax.swing.GroupLayout(IslNakitAvansPanel);
        IslNakitAvansPanel.setLayout(IslNakitAvansPanelLayout);
        IslNakitAvansPanelLayout.setHorizontalGroup(
                IslNakitAvansPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(IslNakitAvansPanelLayout.createSequentialGroup()
                                .addGroup(IslNakitAvansPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(IslNakitAvansPanelLayout.createSequentialGroup()
                                                .addGap(125, 125, 125)
                                                .addComponent(jLabel19)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(IslNakitAvansMiktariTextF, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(IslNakitAvansPanelLayout.createSequentialGroup()
                                                .addGap(263, 263, 263)
                                                .addComponent(IslNakitAvansGonderBtn)))
                                .addContainerGap(220, Short.MAX_VALUE))
        );
        IslNakitAvansPanelLayout.setVerticalGroup(
                IslNakitAvansPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(IslNakitAvansPanelLayout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addGroup(IslNakitAvansPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel19)
                                        .addComponent(IslNakitAvansMiktariTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48)
                                .addComponent(IslNakitAvansGonderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(228, Short.MAX_VALUE))
        );

        IslemlerPanelContainer.add(IslNakitAvansPanel, "cardIslNakitAvansPanel");

        IslParaGönderBtn.setBackground(new java.awt.Color(0, 102, 153));
        IslParaGönderBtn.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        IslParaGönderBtn.setText("Para Gönderme");
        IslParaGönderBtn.addActionListener(this::IslParaGönderBtnActionPerformed);

        IslVadeliBtn.setBackground(new java.awt.Color(0, 102, 153));
        IslVadeliBtn.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        IslVadeliBtn.setText("Vadeli Hesap İşlemleri");
        IslVadeliBtn.addActionListener(this::IslVadeliBtnActionPerformed);

        IslDovizBtn.setBackground(new java.awt.Color(0, 102, 153));
        IslDovizBtn.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        IslDovizBtn.setText("Döviz İşlemleri");
        IslDovizBtn.addActionListener(this::IslDovizBtnActionPerformed);

        IslNakitAvansPanelBtn.setBackground(new java.awt.Color(0, 102, 153));
        IslNakitAvansPanelBtn.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        IslNakitAvansPanelBtn.setText("Nakit Avans Çekme");
        IslNakitAvansPanelBtn.addActionListener(this::IslNakitAvansPanelBtnActionPerformed);

        javax.swing.GroupLayout IslemlerPanelLayout = new javax.swing.GroupLayout(IslemlerPanel);
        IslemlerPanel.setLayout(IslemlerPanelLayout);
        IslemlerPanelLayout.setHorizontalGroup(
                IslemlerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(IslemlerPanelLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addGroup(IslemlerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(IslDovizBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(IslParaGönderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(IslVadeliBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(IslNakitAvansPanelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(55, 55, 55)
                                .addComponent(IslemlerPanelContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(59, Short.MAX_VALUE))
        );
        IslemlerPanelLayout.setVerticalGroup(
                IslemlerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(IslemlerPanelLayout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(IslParaGönderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(IslVadeliBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(IslDovizBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(IslNakitAvansPanelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(98, Short.MAX_VALUE))
                        .addGroup(IslemlerPanelLayout.createSequentialGroup()
                                .addComponent(IslemlerPanelContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        PanelContainer.add(IslemlerPanel, "cardIslemlerPanel");

        HesaplarPanelContainer.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        HesaplarPanelContainer.setPreferredSize(new java.awt.Dimension(800, 500));
        HesaplarPanelContainer.setLayout(new java.awt.CardLayout());

        HspVadesizBakiyeLbl.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        HspVadesizBakiyeLbl.setText("Bakiye");

        HspVadesizIBANLbl.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        HspVadesizIBANLbl.setText("Iban");

        HspVadesizParaTrnsfrBtn.setBackground(new java.awt.Color(0, 102, 153));
        HspVadesizParaTrnsfrBtn.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        HspVadesizParaTrnsfrBtn.setText("Para Transferi Yap");
        HspVadesizParaTrnsfrBtn.addActionListener(this::HspVadesizParaTrnsfrBtnActionPerformed);

        HspVadesizFaturaOdeBtn.setBackground(new java.awt.Color(0, 102, 153));
        HspVadesizFaturaOdeBtn.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        HspVadesizFaturaOdeBtn.setText("Fatura Öde");
        HspVadesizFaturaOdeBtn.addActionListener(this::HspVadesizFaturaOdeBtnActionPerformed);

        jLabel20.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel20.setText("Vadesiz Bakiye:");

        jLabel21.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel21.setText("IBAN:");

        javax.swing.GroupLayout HspVadesizPanelLayout = new javax.swing.GroupLayout(HspVadesizPanel);
        HspVadesizPanel.setLayout(HspVadesizPanelLayout);
        HspVadesizPanelLayout.setHorizontalGroup(
                HspVadesizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(HspVadesizPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(HspVadesizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(HspVadesizFaturaOdeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(HspVadesizParaTrnsfrBtn))
                                .addGap(75, 75, 75))
                        .addGroup(HspVadesizPanelLayout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addGroup(HspVadesizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(HspVadesizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(HspVadesizIBANLbl)
                                        .addComponent(HspVadesizBakiyeLbl))
                                .addContainerGap(492, Short.MAX_VALUE))
        );
        HspVadesizPanelLayout.setVerticalGroup(
                HspVadesizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(HspVadesizPanelLayout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addGroup(HspVadesizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(HspVadesizBakiyeLbl)
                                        .addComponent(jLabel20))
                                .addGap(18, 18, 18)
                                .addGroup(HspVadesizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(HspVadesizIBANLbl)
                                        .addComponent(jLabel21))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                                .addComponent(HspVadesizParaTrnsfrBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(HspVadesizFaturaOdeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53))
        );

        HesaplarPanelContainer.add(HspVadesizPanel, "cardHspVadesizPanel");

        HspVadeliPanel.setLayout(new java.awt.CardLayout());

        HspVadeliListComboBox.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        HspVadeliListComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        HspVadeliTürüLbl.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        HspVadeliTürüLbl.setText("Türü");

        HspVadeliYatirilanTutarLbl.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        HspVadeliYatirilanTutarLbl.setText("Yatırılan Tutar");

        HspVadeliKalanGunLbl.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        HspVadeliKalanGunLbl.setText("Kaç gün kaldı");

        HspVadeliKalanGetirisiLbl.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        HspVadeliKalanGetirisiLbl.setText("Getirisi");

        HspVadeliYeniHesapBtn.setBackground(new java.awt.Color(0, 102, 153));
        HspVadeliYeniHesapBtn.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        HspVadeliYeniHesapBtn.setText("Başka Bir Vadeli Hesap Oluştur");
        HspVadeliYeniHesapBtn.addActionListener(this::HspVadeliYeniHesapBtnActionPerformed);

        jLabel22.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabel22.setText("Vadeli Hesabın Türü:");

        jLabel23.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabel23.setText("Yatırılan Tutar:");

        jLabel24.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabel24.setText("Vade Bitmesine Kalan Gün:");

        jLabel25.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabel25.setText("Vade Getirisi:");

        javax.swing.GroupLayout HspVadeliVarPanelLayout = new javax.swing.GroupLayout(HspVadeliVarPanel);
        HspVadeliVarPanel.setLayout(HspVadeliVarPanelLayout);
        HspVadeliVarPanelLayout.setHorizontalGroup(
                HspVadeliVarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HspVadeliVarPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(HspVadeliYeniHesapBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))
                        .addGroup(HspVadeliVarPanelLayout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(HspVadeliVarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(HspVadeliVarPanelLayout.createSequentialGroup()
                                                .addGroup(HspVadeliVarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel24)
                                                        .addComponent(jLabel22)
                                                        .addComponent(jLabel23)
                                                        .addComponent(jLabel25))
                                                .addGap(44, 44, 44)
                                                .addGroup(HspVadeliVarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(HspVadeliKalanGunLbl)
                                                        .addComponent(HspVadeliTürüLbl)
                                                        .addComponent(HspVadeliKalanGetirisiLbl)
                                                        .addComponent(HspVadeliYatirilanTutarLbl)))
                                        .addGroup(HspVadeliVarPanelLayout.createSequentialGroup()
                                                .addGap(53, 53, 53)
                                                .addComponent(HspVadeliListComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(293, Short.MAX_VALUE))
        );
        HspVadeliVarPanelLayout.setVerticalGroup(
                HspVadeliVarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(HspVadeliVarPanelLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(HspVadeliListComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addGroup(HspVadeliVarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(HspVadeliTürüLbl)
                                        .addComponent(jLabel22))
                                .addGap(42, 42, 42)
                                .addGroup(HspVadeliVarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(HspVadeliYatirilanTutarLbl)
                                        .addComponent(jLabel23))
                                .addGap(44, 44, 44)
                                .addGroup(HspVadeliVarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(HspVadeliKalanGunLbl)
                                        .addComponent(jLabel24))
                                .addGap(34, 34, 34)
                                .addGroup(HspVadeliVarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(HspVadeliKalanGetirisiLbl)
                                        .addComponent(jLabel25))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addComponent(HspVadeliYeniHesapBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28))
        );

        HspVadeliPanel.add(HspVadeliVarPanel, "cardHspVadeliVarPanel");

        lbl9.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        lbl9.setText("Vadeli Hesabınız Bulunmamaktadır");

        HspVadeliAcBtn.setBackground(new java.awt.Color(0, 102, 102));
        HspVadeliAcBtn.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        HspVadeliAcBtn.setText("VADELİ HESAP AÇ");
        HspVadeliAcBtn.addActionListener(this::HspVadeliAcBtnActionPerformed);

        javax.swing.GroupLayout HspVadeliYokPanelLayout = new javax.swing.GroupLayout(HspVadeliYokPanel);
        HspVadeliYokPanel.setLayout(HspVadeliYokPanelLayout);
        HspVadeliYokPanelLayout.setHorizontalGroup(
                HspVadeliYokPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(HspVadeliYokPanelLayout.createSequentialGroup()
                                .addGroup(HspVadeliYokPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(HspVadeliYokPanelLayout.createSequentialGroup()
                                                .addGap(190, 190, 190)
                                                .addComponent(HspVadeliAcBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(HspVadeliYokPanelLayout.createSequentialGroup()
                                                .addGap(144, 144, 144)
                                                .addComponent(lbl9)))
                                .addContainerGap(145, Short.MAX_VALUE))
        );
        HspVadeliYokPanelLayout.setVerticalGroup(
                HspVadeliYokPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(HspVadeliYokPanelLayout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(lbl9)
                                .addGap(47, 47, 47)
                                .addComponent(HspVadeliAcBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(164, Short.MAX_VALUE))
        );

        HspVadeliPanel.add(HspVadeliYokPanel, "cardHspVadeliYokPanel");

        HesaplarPanelContainer.add(HspVadeliPanel, "cardHspVadeliPanel");

        HspDovizDolarBakiyeLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        HspDovizDolarBakiyeLabel.setText("Dolar Bakiyesi");

        HspDovizEuroBakiyeLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        HspDovizEuroBakiyeLabel.setText("Euro Bakiyesi");

        HspDovizAltınBakiyeLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        HspDovizAltınBakiyeLabel.setText("Altın Bakiyesi");

        HspDovizDolarTLLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        HspDovizDolarTLLabel.setText("Dolar-TL");

        HspDovizEuroTLLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        HspDovizEuroTLLabel.setText("Euro-TL");

        HspDovizAltınTLLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        HspDovizAltınTLLabel.setText("Altın-TL");

        HspDovizIslemleriBtn.setBackground(new java.awt.Color(51, 102, 0));
        HspDovizIslemleriBtn.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        HspDovizIslemleriBtn.setText("Döviz İşlemleri");
        HspDovizIslemleriBtn.addActionListener(this::HspDovizIslemleriBtnActionPerformed);

        label12.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        label12.setText("Dolar Bakiyesi:");

        label13.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        label13.setText("Euro Bakiyesi:");

        label14.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        label14.setText("Altın Bakiyesi:");

        jLabel26.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel26.setText("TL Karşılığı:");

        jLabel27.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel27.setText("TL Karşılığı:");

        jLabel28.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel28.setText("TL Karşılığı:");

        javax.swing.GroupLayout HspDovizPanelLayout = new javax.swing.GroupLayout(HspDovizPanel);
        HspDovizPanel.setLayout(HspDovizPanelLayout);
        HspDovizPanelLayout.setHorizontalGroup(
                HspDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(HspDovizPanelLayout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addGroup(HspDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(label12)
                                        .addComponent(label13)
                                        .addComponent(label14))
                                .addGap(18, 18, 18)
                                .addGroup(HspDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(HspDovizDolarBakiyeLabel)
                                        .addComponent(HspDovizAltınBakiyeLabel)
                                        .addComponent(HspDovizEuroBakiyeLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 176, Short.MAX_VALUE)
                                .addGroup(HspDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel28)
                                        .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(HspDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(HspDovizEuroTLLabel)
                                        .addComponent(HspDovizDolarTLLabel)
                                        .addComponent(HspDovizAltınTLLabel))
                                .addGap(130, 130, 130))
                        .addGroup(HspDovizPanelLayout.createSequentialGroup()
                                .addGap(298, 298, 298)
                                .addComponent(HspDovizIslemleriBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        HspDovizPanelLayout.setVerticalGroup(
                HspDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(HspDovizPanelLayout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addGroup(HspDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(HspDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(HspDovizDolarTLLabel)
                                                .addComponent(jLabel26))
                                        .addGroup(HspDovizPanelLayout.createSequentialGroup()
                                                .addGroup(HspDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(label12)
                                                        .addComponent(HspDovizDolarBakiyeLabel))
                                                .addGap(77, 77, 77)
                                                .addGroup(HspDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(label13)
                                                        .addComponent(HspDovizEuroBakiyeLabel)
                                                        .addComponent(jLabel27)
                                                        .addComponent(HspDovizEuroTLLabel))
                                                .addGap(60, 60, 60)
                                                .addGroup(HspDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(label14)
                                                        .addComponent(HspDovizAltınBakiyeLabel)
                                                        .addComponent(jLabel28)
                                                        .addComponent(HspDovizAltınTLLabel))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                                .addComponent(HspDovizIslemleriBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32))
        );

        HesaplarPanelContainer.add(HspDovizPanel, "cardHspDovizPanel");

        HspVadesizBtn.setBackground(new java.awt.Color(0, 102, 153));
        HspVadesizBtn.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        HspVadesizBtn.setText("Vadesiz");
        HspVadesizBtn.addActionListener(this::HspVadesizBtnActionPerformed);

        HspVadeliBtn.setBackground(new java.awt.Color(0, 102, 153));
        HspVadeliBtn.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        HspVadeliBtn.setText("Vadeli");
        HspVadeliBtn.addActionListener(this::HspVadeliBtnActionPerformed);

        HspDövizBtn.setBackground(new java.awt.Color(0, 102, 153));
        HspDövizBtn.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        HspDövizBtn.setText("Döviz");
        HspDövizBtn.addActionListener(this::HspDövizBtnActionPerformed);

        javax.swing.GroupLayout HesaplarPanelLayout = new javax.swing.GroupLayout(HesaplarPanel);
        HesaplarPanel.setLayout(HesaplarPanelLayout);
        HesaplarPanelLayout.setHorizontalGroup(
                HesaplarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(HesaplarPanelLayout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addGroup(HesaplarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(HspVadesizBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(HspVadeliBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(HspDövizBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                                .addComponent(HesaplarPanelContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39))
        );
        HesaplarPanelLayout.setVerticalGroup(
                HesaplarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(HesaplarPanelLayout.createSequentialGroup()
                                .addGroup(HesaplarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(HesaplarPanelLayout.createSequentialGroup()
                                                .addGap(76, 76, 76)
                                                .addComponent(HspVadesizBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(HspVadeliBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(HspDövizBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(HesaplarPanelLayout.createSequentialGroup()
                                                .addGap(23, 23, 23)
                                                .addComponent(HesaplarPanelContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(23, Short.MAX_VALUE))
        );

        PanelContainer.add(HesaplarPanel, "cardHesaplarPanel");

        KrtBankaKartiPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbl6.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        lbl6.setText("Banka Kartı");

        BankaKartNoLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        BankaKartNoLabel.setText("debitcardnumber");

        BankaKartCVVLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        BankaKartCVVLabel.setText("debit cvv");

        BankaKartSKTLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        BankaKartSKTLabel.setText("debit skt");

        BankaKartAdSoyadLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        BankaKartAdSoyadLabel.setText("debit ad soyad");

        BankaKartBakiye.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        BankaKartBakiye.setText("debit bakiye");

        jLabel29.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel29.setText("Kart Numarası:");

        jLabel30.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel30.setText("Kart Bakiyesi:");

        jLabel33.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel33.setText("SKT:");

        jLabel34.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel34.setText("CVV:");

        javax.swing.GroupLayout KrtBankaKartiPanelLayout = new javax.swing.GroupLayout(KrtBankaKartiPanel);
        KrtBankaKartiPanel.setLayout(KrtBankaKartiPanelLayout);
        KrtBankaKartiPanelLayout.setHorizontalGroup(
                KrtBankaKartiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(KrtBankaKartiPanelLayout.createSequentialGroup()
                                .addComponent(lbl6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KrtBankaKartiPanelLayout.createSequentialGroup()
                                .addGroup(KrtBankaKartiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(KrtBankaKartiPanelLayout.createSequentialGroup()
                                                .addGap(37, 37, 37)
                                                .addComponent(jLabel29)
                                                .addGap(14, 14, 14))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KrtBankaKartiPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(KrtBankaKartiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KrtBankaKartiPanelLayout.createSequentialGroup()
                                                                .addComponent(jLabel33)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(BankaKartSKTLabel))
                                                        .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(KrtBankaKartiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(KrtBankaKartiPanelLayout.createSequentialGroup()
                                                .addGroup(KrtBankaKartiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(BankaKartBakiye)
                                                        .addComponent(BankaKartNoLabel))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(BankaKartAdSoyadLabel)
                                                .addGap(57, 57, 57))
                                        .addGroup(KrtBankaKartiPanelLayout.createSequentialGroup()
                                                .addGap(56, 56, 56)
                                                .addComponent(jLabel34)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(BankaKartCVVLabel)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        KrtBankaKartiPanelLayout.setVerticalGroup(
                KrtBankaKartiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(KrtBankaKartiPanelLayout.createSequentialGroup()
                                .addComponent(lbl6)
                                .addGap(18, 18, 18)
                                .addGroup(KrtBankaKartiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(BankaKartNoLabel)
                                        .addComponent(BankaKartAdSoyadLabel)
                                        .addComponent(jLabel29))
                                .addGap(26, 26, 26)
                                .addGroup(KrtBankaKartiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(BankaKartBakiye)
                                        .addComponent(jLabel30))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                                .addGroup(KrtBankaKartiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(BankaKartCVVLabel)
                                        .addGroup(KrtBankaKartiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(BankaKartSKTLabel)
                                                .addComponent(jLabel33))
                                        .addComponent(jLabel34))
                                .addGap(41, 41, 41))
        );

        KrtKrediKartiPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbl7.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        lbl7.setText("Kredi Kartı");

        KrediKartNoLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        KrediKartNoLabel.setText("credit card number");

        KrediKartCVVLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        KrediKartCVVLabel.setText("credit cvv");

        KrediKartSKTLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        KrediKartSKTLabel.setText("credt skt");

        KrediKartAdSoyadLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        KrediKartAdSoyadLabel.setText("credit ad soyad");

        KrediKartLimitLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        KrediKartLimitLabel.setText("credit limit");

        KrediKartKullanılabilirBakiyeLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        KrediKartKullanılabilirBakiyeLabel.setText("credit kullanılabilir bakiye");

        KrediKartBorcLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        KrediKartBorcLabel.setText("credit borc");

        KrediKartBorcOdeBtn.setBackground(new java.awt.Color(102, 102, 0));
        KrediKartBorcOdeBtn.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        KrediKartBorcOdeBtn.setText("Borç Öde");
        KrediKartBorcOdeBtn.addActionListener(this::KrediKartBorcOdeBtnActionPerformed);

        KrediKartNakitAvansBtn.setBackground(new java.awt.Color(102, 102, 0));
        KrediKartNakitAvansBtn.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        KrediKartNakitAvansBtn.setText("Nakit Avans Çek");
        KrediKartNakitAvansBtn.addActionListener(this::KrediKartNakitAvansBtnActionPerformed);

        jLabel35.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel35.setText("Kart Numarası:");

        jLabel36.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel36.setText("Kullanılabilir Bakiye");

        jLabel37.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel37.setText("Borç:");

        jLabel38.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel38.setText("Limit:");

        jLabel39.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel39.setText("SKT:");

        jLabel40.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel40.setText("CVV:");

        javax.swing.GroupLayout KrtKrediKartiPanelLayout = new javax.swing.GroupLayout(KrtKrediKartiPanel);
        KrtKrediKartiPanel.setLayout(KrtKrediKartiPanelLayout);
        KrtKrediKartiPanelLayout.setHorizontalGroup(
                KrtKrediKartiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(KrtKrediKartiPanelLayout.createSequentialGroup()
                                .addComponent(lbl7)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(KrtKrediKartiPanelLayout.createSequentialGroup()
                                .addGap(0, 11, Short.MAX_VALUE)
                                .addGroup(KrtKrediKartiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(KrtKrediKartiPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel39)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(KrediKartSKTLabel)
                                                .addGap(44, 44, 44)
                                                .addComponent(jLabel40)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(KrediKartCVVLabel))
                                        .addGroup(KrtKrediKartiPanelLayout.createSequentialGroup()
                                                .addGroup(KrtKrediKartiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING))
                                                .addGap(18, 18, 18)
                                                .addGroup(KrtKrediKartiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(KrediKartKullanılabilirBakiyeLabel)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KrtKrediKartiPanelLayout.createSequentialGroup()
                                                                .addComponent(KrediKartNoLabel)
                                                                .addGap(321, 321, 321)
                                                                .addComponent(KrediKartAdSoyadLabel)))))
                                .addGap(51, 51, 51))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KrtKrediKartiPanelLayout.createSequentialGroup()
                                .addGroup(KrtKrediKartiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(KrtKrediKartiPanelLayout.createSequentialGroup()
                                                .addGap(118, 118, 118)
                                                .addGroup(KrtKrediKartiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.TRAILING))
                                                .addGap(18, 18, 18)
                                                .addGroup(KrtKrediKartiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(KrediKartBorcLabel)
                                                        .addComponent(KrediKartLimitLabel))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(KrediKartBorcOdeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, KrtKrediKartiPanelLayout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(KrediKartNakitAvansBtn)))
                                .addGap(36, 36, 36))
        );
        KrtKrediKartiPanelLayout.setVerticalGroup(
                KrtKrediKartiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(KrtKrediKartiPanelLayout.createSequentialGroup()
                                .addComponent(lbl7)
                                .addGap(18, 18, 18)
                                .addGroup(KrtKrediKartiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(KrediKartNoLabel)
                                        .addComponent(KrediKartAdSoyadLabel)
                                        .addComponent(jLabel35))
                                .addGap(18, 18, 18)
                                .addGroup(KrtKrediKartiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel36)
                                        .addComponent(KrediKartKullanılabilirBakiyeLabel))
                                .addGap(8, 8, 8)
                                .addGroup(KrtKrediKartiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel38)
                                        .addComponent(KrediKartLimitLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(KrtKrediKartiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(KrediKartBorcLabel)
                                        .addComponent(jLabel37)
                                        .addComponent(KrediKartBorcOdeBtn))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                                .addGroup(KrtKrediKartiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(KrediKartNakitAvansBtn)
                                        .addGroup(KrtKrediKartiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(KrediKartSKTLabel)
                                                .addComponent(jLabel39)
                                                .addComponent(jLabel40)
                                                .addComponent(KrediKartCVVLabel)))
                                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout KartlarPanelLayout = new javax.swing.GroupLayout(KartlarPanel);
        KartlarPanel.setLayout(KartlarPanelLayout);
        KartlarPanelLayout.setHorizontalGroup(
                KartlarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(KartlarPanelLayout.createSequentialGroup()
                                .addGap(212, 212, 212)
                                .addGroup(KartlarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(KrtKrediKartiPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(KrtBankaKartiPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(182, Short.MAX_VALUE))
        );
        KartlarPanelLayout.setVerticalGroup(
                KartlarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(KartlarPanelLayout.createSequentialGroup()
                                .addComponent(KrtBankaKartiPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(KrtKrediKartiPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(8, Short.MAX_VALUE))
        );

        PanelContainer.add(KartlarPanel, "cardKartlarPanel");

        FtrAboneliklerimBtn.setBackground(new java.awt.Color(0, 102, 153));
        FtrAboneliklerimBtn.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        FtrAboneliklerimBtn.setText("Aboneliklerim");
        FtrAboneliklerimBtn.addActionListener(this::FtrAboneliklerimBtnActionPerformed);

        FtrFaturalarımBtn.setBackground(new java.awt.Color(0, 102, 153));
        FtrFaturalarımBtn.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        FtrFaturalarımBtn.setText("Faturalarım");
        FtrFaturalarımBtn.addActionListener(this::FtrFaturalarımBtnActionPerformed);

        FaturalarPanelContainer.setLayout(new java.awt.CardLayout());

        FtrAboneliklerimTable.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        FtrAboneliklerimTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(FtrAboneliklerimTable);

        javax.swing.GroupLayout FtrAboneliklerimPanelLayout = new javax.swing.GroupLayout(FtrAboneliklerimPanel);
        FtrAboneliklerimPanel.setLayout(FtrAboneliklerimPanelLayout);
        FtrAboneliklerimPanelLayout.setHorizontalGroup(
                FtrAboneliklerimPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(FtrAboneliklerimPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                                .addContainerGap())
        );
        FtrAboneliklerimPanelLayout.setVerticalGroup(
                FtrAboneliklerimPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(FtrAboneliklerimPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        FaturalarPanelContainer.add(FtrAboneliklerimPanel, "cardFtrAboneliklerimPanel");

        FtrFaturalarimTable.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        FtrFaturalarimTable.setModel(new javax.swing.table.DefaultTableModel(
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
        FtrFaturalarimTables.setViewportView(FtrFaturalarimTable);

        FaturaOdeBtn.setBackground(new java.awt.Color(0, 102, 153));
        FaturaOdeBtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        FaturaOdeBtn.setText("Fatura Öde");
        FaturaOdeBtn.addActionListener(this::FaturaOdeBtnActionPerformed);

        javax.swing.GroupLayout FtrFaturalarımPanelLayout = new javax.swing.GroupLayout(FtrFaturalarımPanel);
        FtrFaturalarımPanel.setLayout(FtrFaturalarımPanelLayout);
        FtrFaturalarımPanelLayout.setHorizontalGroup(
                FtrFaturalarımPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(FtrFaturalarımPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(FtrFaturalarimTables, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                .addComponent(FaturaOdeBtn)
                                .addGap(20, 20, 20))
        );
        FtrFaturalarımPanelLayout.setVerticalGroup(
                FtrFaturalarımPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(FtrFaturalarımPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(FtrFaturalarımPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FtrFaturalarımPanelLayout.createSequentialGroup()
                                                .addComponent(FtrFaturalarimTables, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(31, 31, 31))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FtrFaturalarımPanelLayout.createSequentialGroup()
                                                .addComponent(FaturaOdeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(103, 103, 103))))
        );

        FaturalarPanelContainer.add(FtrFaturalarımPanel, "cardFtrFaturalarımPanel");

        javax.swing.GroupLayout FaturalarPanelLayout = new javax.swing.GroupLayout(FaturalarPanel);
        FaturalarPanel.setLayout(FaturalarPanelLayout);
        FaturalarPanelLayout.setHorizontalGroup(
                FaturalarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(FaturalarPanelLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(FaturalarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(FtrFaturalarımBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(FtrAboneliklerimBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                                .addComponent(FaturalarPanelContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30))
        );
        FaturalarPanelLayout.setVerticalGroup(
                FaturalarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(FaturalarPanelLayout.createSequentialGroup()
                                .addGroup(FaturalarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(FaturalarPanelLayout.createSequentialGroup()
                                                .addGap(61, 61, 61)
                                                .addComponent(FtrAboneliklerimBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(39, 39, 39)
                                                .addComponent(FtrFaturalarımBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(FaturalarPanelLayout.createSequentialGroup()
                                                .addGap(28, 28, 28)
                                                .addComponent(FaturalarPanelContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(50, Short.MAX_VALUE))
        );

        PanelContainer.add(FaturalarPanel, "cardFaturalarPanel");

        VarliklarTLLabel.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        VarliklarTLLabel.setText("jLabel20");

        VarliklarDolarLabel.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        VarliklarDolarLabel.setText("jLabel21");

        VarliklarEuroLabel.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        VarliklarEuroLabel.setText("jLabel22");

        VarliklarAltinLabel.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        VarliklarAltinLabel.setText("jLabel23");

        jLabel31.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel31.setText("TL");

        jLabel32.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel32.setText("Dolar");

        jLabel41.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel41.setText("Euro");

        jLabel42.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel42.setText("Altın");

        javax.swing.GroupLayout VarliklarPanelLayout = new javax.swing.GroupLayout(VarliklarPanel);
        VarliklarPanel.setLayout(VarliklarPanelLayout);
        VarliklarPanelLayout.setHorizontalGroup(
                VarliklarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(VarliklarPanelLayout.createSequentialGroup()
                                .addGroup(VarliklarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(VarliklarPanelLayout.createSequentialGroup()
                                                .addGap(94, 94, 94)
                                                .addComponent(VarliklarTLLabel)
                                                .addGap(196, 196, 196)
                                                .addComponent(VarliklarDolarLabel)
                                                .addGap(184, 184, 184))
                                        .addGroup(VarliklarPanelLayout.createSequentialGroup()
                                                .addGap(113, 113, 113)
                                                .addComponent(jLabel31)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel32)
                                                .addGap(192, 192, 192)))
                                .addGroup(VarliklarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(VarliklarPanelLayout.createSequentialGroup()
                                                .addComponent(VarliklarEuroLabel)
                                                .addGap(165, 165, 165)
                                                .addComponent(VarliklarAltinLabel))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, VarliklarPanelLayout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addComponent(jLabel41)
                                                .addGap(196, 196, 196)
                                                .addComponent(jLabel42)))
                                .addContainerGap(177, Short.MAX_VALUE))
        );
        VarliklarPanelLayout.setVerticalGroup(
                VarliklarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(VarliklarPanelLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addGroup(VarliklarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel31)
                                        .addComponent(jLabel32)
                                        .addComponent(jLabel41)
                                        .addComponent(jLabel42))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(VarliklarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(VarliklarTLLabel)
                                        .addComponent(VarliklarDolarLabel)
                                        .addComponent(VarliklarEuroLabel)
                                        .addComponent(VarliklarAltinLabel))
                                .addContainerGap(359, Short.MAX_VALUE))
        );

        PanelContainer.add(VarliklarPanel, "cardVarliklarPanel");

        GuncelKurDolarAlısLabel.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        GuncelKurDolarAlısLabel.setText("GuncelKurDolarAlıs");

        GuncelKurDolarSatısLabel.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        GuncelKurDolarSatısLabel.setText("GuncelKurDolarSatıs");

        GuncelKurEuroAlısLabel.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        GuncelKurEuroAlısLabel.setText("GuncelKurEuroAlıs");

        GuncelKurEuroSatisLabel.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        GuncelKurEuroSatisLabel.setText("GuncelKurEuroSatis");

        GuncelKurAltinAlısLabel.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        GuncelKurAltinAlısLabel.setText("GuncelKurAltinAlıs");

        GuncelKurAltinSatisLabel.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        GuncelKurAltinSatisLabel.setText("GuncelKurAltinSatis");

        GuncelKurDovizIslemleriYonlendirmeBtn.setBackground(new java.awt.Color(0, 102, 0));
        GuncelKurDovizIslemleriYonlendirmeBtn.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        GuncelKurDovizIslemleriYonlendirmeBtn.setText("Döviz İşlemleri");
        GuncelKurDovizIslemleriYonlendirmeBtn.addActionListener(this::GuncelKurDovizIslemleriYonlendirmeBtnActionPerformed);

        javax.swing.GroupLayout GuncelKurPanelLayout = new javax.swing.GroupLayout(GuncelKurPanel);
        GuncelKurPanel.setLayout(GuncelKurPanelLayout);
        GuncelKurPanelLayout.setHorizontalGroup(
                GuncelKurPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(GuncelKurPanelLayout.createSequentialGroup()
                                .addGap(165, 165, 165)
                                .addGroup(GuncelKurPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(GuncelKurPanelLayout.createSequentialGroup()
                                                .addGroup(GuncelKurPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(GuncelKurDolarSatısLabel)
                                                        .addComponent(GuncelKurDolarAlısLabel))
                                                .addGap(123, 123, 123)
                                                .addGroup(GuncelKurPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(GuncelKurEuroSatisLabel)
                                                        .addGroup(GuncelKurPanelLayout.createSequentialGroup()
                                                                .addGap(5, 5, 5)
                                                                .addComponent(GuncelKurEuroAlısLabel))))
                                        .addComponent(GuncelKurDovizIslemleriYonlendirmeBtn))
                                .addGap(115, 115, 115)
                                .addGroup(GuncelKurPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(GuncelKurAltinAlısLabel)
                                        .addComponent(GuncelKurAltinSatisLabel))
                                .addContainerGap(154, Short.MAX_VALUE))
        );
        GuncelKurPanelLayout.setVerticalGroup(
                GuncelKurPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(GuncelKurPanelLayout.createSequentialGroup()
                                .addGap(112, 112, 112)
                                .addGroup(GuncelKurPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(GuncelKurDolarAlısLabel)
                                        .addComponent(GuncelKurEuroAlısLabel)
                                        .addComponent(GuncelKurAltinAlısLabel))
                                .addGap(17, 17, 17)
                                .addGroup(GuncelKurPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(GuncelKurDolarSatısLabel)
                                        .addComponent(GuncelKurEuroSatisLabel)
                                        .addComponent(GuncelKurAltinSatisLabel))
                                .addGap(119, 119, 119)
                                .addComponent(GuncelKurDovizIslemleriYonlendirmeBtn)
                                .addContainerGap(136, Short.MAX_VALUE))
        );

        PanelContainer.add(GuncelKurPanel, "cardGuncelKurPanel");

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
                MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(PanelContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(UstPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MainPanelLayout.setVerticalGroup(
                MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                                .addComponent(UstPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(PanelContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(YonlendirmePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(YonlendirmePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>



    private void AnaSayfaBtnActionPerformed(java.awt.event.ActionEvent evt) {
        mainSayfaDegistir("cardAnaSayfaPanel");
        panelAdiLabel.setText("ANA SAYFA");

    }

    private void IslemlerBtnActionPerformed(java.awt.event.ActionEvent evt) {
        mainSayfaDegistir("cardIslemlerPanel");
        panelAdiLabel.setText("İŞLEMLER");

    }

    private void HesaplarBtnActionPerformed(java.awt.event.ActionEvent evt) {
        mainSayfaDegistir("cardHesaplarPanel");
        panelAdiLabel.setText("HESAPLARIM");
    }

    private void KartlarBtnActionPerformed(java.awt.event.ActionEvent evt) {
        mainSayfaDegistir("cardKartlarPanel");
        panelAdiLabel.setText("KARTLARIM");
    }

    private void FaturalarBtnActionPerformed(java.awt.event.ActionEvent evt) {
        mainSayfaDegistir("cardFaturalarPanel");
        panelAdiLabel.setText("FATURA VE ÖDEMELER");
    }

    private void VarliklarBtnActionPerformed(java.awt.event.ActionEvent evt) {
        mainSayfaDegistir("cardVarliklarPanel");
        panelAdiLabel.setText("VARLIKLARIM");
    }

    private void GuncelKurBtnActionPerformed(java.awt.event.ActionEvent evt) {
        mainSayfaDegistir("cardGuncelKurPanel");
        panelAdiLabel.setText("DÖVİZ KURLARI");
    }

    private void IslParaGönderBtnActionPerformed(java.awt.event.ActionEvent evt) {
        islemlerSayfaDegistir("cardIslParaGönderPanel");
    }

    private void IslVadeliBtnActionPerformed(java.awt.event.ActionEvent evt) {
        islemlerSayfaDegistir("cardIslVadeliPanel");
    }

    private void IslDovizBtnActionPerformed(java.awt.event.ActionEvent evt) {
        islemlerSayfaDegistir("cardIslDovizPanel");
    }

    private void IslNakitAvansPanelBtnActionPerformed(java.awt.event.ActionEvent evt) {
        islemlerSayfaDegistir("cardIslNakitAvansPanel");
    }

    private void HspVadesizBtnActionPerformed(java.awt.event.ActionEvent evt) {
        hesaplarSayfaDegistir("cardHspVadesizPanel");
    }

    private void HspVadeliBtnActionPerformed(java.awt.event.ActionEvent evt) {
        hesaplarSayfaDegistir("cardHspVadeliPanel");
        vadeliHesapSayfasiniYonet(); // Listeyi anında tazele
    }

    private void HspDövizBtnActionPerformed(java.awt.event.ActionEvent evt) {
        hesaplarSayfaDegistir("cardHspDovizPanel");
    }

    private void FtrAboneliklerimBtnActionPerformed(java.awt.event.ActionEvent evt) {
        faturalarSayfaDegistir("cardFtrAboneliklerimPanel");
        abonelikleriGuncelle(); // Sayfa açılınca listeyi getir
    }

    private void FtrFaturalarımBtnActionPerformed(java.awt.event.ActionEvent evt) {
        faturalarSayfaDegistir("cardFtrFaturalarımPanel");
        faturalariGuncelle(); // Sayfa açılınca listeyi getir
    }

    private void HspVadeliAcBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // 1. Ana ekranı "İşlemler" paneline çevir
        mainSayfaDegistir("cardIslemlerPanel");

        // 2. Başlığı güncelle
        panelAdiLabel.setText("İŞLEMLER");

        // 3. İşlemler içindeki alt paneli "Vadeli İşlem Formu"na çevir
        islemlerSayfaDegistir("cardIslVadeliPanel");
    }

    private void HspVadeliYeniHesapBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // Mantık birebir aynı, bu da işlem sayfasına yönlendirir
        mainSayfaDegistir("cardIslemlerPanel");
        panelAdiLabel.setText("İŞLEMLER");
        islemlerSayfaDegistir("cardIslVadeliPanel");
    }

    private void HspVadesizParaTrnsfrBtnActionPerformed(java.awt.event.ActionEvent evt) {
        mainSayfaDegistir("cardIslemlerPanel");
        panelAdiLabel.setText("İŞLEMLER");
        islemlerSayfaDegistir("cardIslParaGönderPanel");
    }

    private void HspVadesizFaturaOdeBtnActionPerformed(java.awt.event.ActionEvent evt) {
        mainSayfaDegistir("cardFaturalarPanel");
        panelAdiLabel.setText("FATURA VE ÖDEMELER");
    }

    private void HspDovizIslemleriBtnActionPerformed(java.awt.event.ActionEvent evt) {
        mainSayfaDegistir("cardIslemlerPanel");
        panelAdiLabel.setText("İŞLEMLER");
        islemlerSayfaDegistir("cardIslDovizPanel");
    }

    private void GonderBtnActionPerformed(java.awt.event.ActionEvent evt) {
        String aliciIban = GonderilecekIBANTextF.getText().trim();
        String miktarStr = GonderilecekMiktarTextF.getText().trim();

        if(aliciIban.isEmpty() || miktarStr.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Lütfen tüm alanları doldurun.");
            return;
        }

        try {
            double miktar = Double.parseDouble(miktarStr);

            // 1. Kaynak Hesabı (Kendi Hesabını) Getir
            model.CheckingAccount sourceAccount = Managers.DataBaseManager.getCheckingAccountObject(aktifKullanici.getUserId());

            // 2. Hedef Hesabı (Karşı Tarafı) IBAN ile Bul
            String targetAccountId = Managers.DataBaseManager.getAccountIdByIBAN(aliciIban);

            if (targetAccountId == null) {
                // Eğer veritabanından NULL dönerse, demek ki böyle bir hesap yok.
                // Manuel olarak hatayı fırlatıyoruz:
                throw new Exceptions.HesapBulunamadiException("Girilen IBAN (" + aliciIban + ") sistemde bulunamadı!");
            }

            // Hesap varsa nesneyi çek
            model.Account targetAccount = Managers.DataBaseManager.getAccountById(targetAccountId);

            if (sourceAccount != null) {
                // Transferi Yap (Bu da YetersizBakiyeException fırlatabilir)
                boolean sonuc = sourceAccount.transferTo(targetAccount, miktar);

                if (sonuc) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Transfer Başarılı!");
                    hesaplariGuncelle();
                    anaSayfaGuncelle();
                    varliklariGuncelle();
                }
            }

            // --- HATALARI YAKALADIĞIMIZ YER (CATCH BLOKLARI) ---

        } catch (Exceptions.HesapBulunamadiException e) {
            // Yanlış IBAN girilince burası çalışır
            javax.swing.JOptionPane.showMessageDialog(this, e.getMessage(), "Hesap Bulunamadı", javax.swing.JOptionPane.ERROR_MESSAGE);

        } catch (Exceptions.YetersizBakiyeException e) {
            // Para yetmezse burası çalışır
            javax.swing.JOptionPane.showMessageDialog(this, e.getMessage(), "Yetersiz Bakiye", javax.swing.JOptionPane.WARNING_MESSAGE);

        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Lütfen geçerli bir tutar giriniz.");
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Beklenmedik Hata: " + e.getMessage());
        }
    }

    private void IslVadeliHesapOnizleActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String miktarStr = IslVadeYatirilacakMiktarTextF.getText();
            if(miktarStr.isEmpty()) return;

            double miktar = Double.parseDouble(miktarStr);
            String secilenVade = (String) IslVadeSecenekleriComboBox.getSelectedItem();

            int gun = 32;
            if (secilenVade.contains("92")) gun = 92;
            else if (secilenVade.contains("181")) gun = 181;
            else if (secilenVade.contains("365")) gun = 365;

            // --- DEĞİŞİKLİK BURADA ---
            // Artık formül UI'da değil, Model'de!
            double netKazanc = model.DepositAccount.calculateProjectedNetProfit(miktar, gun);

            IslVadeliKazancLabel.setText("Tahmini Net Getiri: " + String.format("%.2f TL", netKazanc));
            IslVadeliBilgilendirmeLabel.setText("Vade Sonu Toplam: " + String.format("%.2f TL", (miktar + netKazanc)));

        } catch (Exception e) {
            IslVadeliKazancLabel.setText("Hesaplama Hatası");
        }
    }

    private void IslVadeliHesapOlusturActionPerformed(java.awt.event.ActionEvent evt) {
        String ad = IslVadeliHesapAdlandirmaTextF.getText();
        String miktarStr = IslVadeYatirilacakMiktarTextF.getText();
        String secilenVade = (String) IslVadeSecenekleriComboBox.getSelectedItem();

        if(ad.isEmpty() || miktarStr.isEmpty()) return;

        int vadeGun = 32;
        if (secilenVade.contains("92")) vadeGun = 92;
        else if (secilenVade.contains("181")) vadeGun = 181;
        else if (secilenVade.contains("365")) vadeGun = 365;

        try {
            double miktar = Double.parseDouble(miktarStr);

            String sonuc = Managers.BankService.openDepositAccount(aktifKullanici.getUserId(), ad, miktar, vadeGun);

            if (sonuc.equals("BASARILI")) {
                javax.swing.JOptionPane.showMessageDialog(this, "Vadeli Hesap Açıldı!");

                // --- EKRANLARI YENİLE ---
                hesaplariGuncelle();
                anaSayfaGuncelle();
                vadeliHesapSayfasiniYonet(); // Hesaplar sekmesini yeniler
                varliklariGuncelle();       // Varlıkları yeniler (TL azaldı, Vadeli arttı)

                // --- UNUTULAN KISIM BURASIYDI: ---
                vadeliIslemBilgisiniGuncelle(); // "Hiç hesabınız yok" yazısını günceller!
                // ---------------------------------

                // Hesaplar sayfasına yönlendir
                mainSayfaDegistir("cardHesaplarPanel");
                hesaplarSayfaDegistir("cardHspVadeliPanel");
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, sonuc);
            }

        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Geçersiz Tutar.");
        }
    }

    private void IslVadeliVadeliHesapGormeBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // 1. Önce ANA EKRANI "Hesaplar" sekmesine geçir (Eksik olan buydu)
        mainSayfaDegistir("cardHesaplarPanel");
        panelAdiLabel.setText("HESAPLARIM");

        // 2. Sonra Hesaplar içindeki alt sekmeyi "Vadeli" yap
        hesaplarSayfaDegistir("cardHspVadeliPanel");

        // 3. Verileri tazele
        vadeliHesapSayfasiniYonet();
    }

    private void IslDovizDolarIslemiActionPerformed(java.awt.event.ActionEvent evt) {
        dovizIslemiYap("DOLAR", IslAlınacakDolarMiktariTextF, IslSatilacakDolarMiktariTextF, DolarAlRadioBtn, DolarSatRadioBtn);
    }

    private void IslDovizEuroIslemiActionPerformed(java.awt.event.ActionEvent evt) {
        dovizIslemiYap("EURO", IslAlınacakEuroMiktariTextF, IslSatilacakEuroMiktariTextF, EuroAlRadioBtn, EuroSatRadioBtn);
    }

    private void IslDovizAltinIslemiActionPerformed(java.awt.event.ActionEvent evt) {
        // "ALTIN" parametresi gönderiyoruz, yukarıdaki metot bunu "GOLD"a çevirip işlem yapacak.
        dovizIslemiYap( "ALTIN",IslAlınacakAltınMiktariTextF,IslSatılacakAlMiktariTextF,AltinAlRadioBtn,AltinSatRadioBtn);
    }

    private void AnaSayfaBorcOdeBtnActionPerformed(java.awt.event.ActionEvent evt) {
        KrediKartBorcOdeBtnActionPerformed(evt);
    }

    private void IslNakitAvansGonderBtnActionPerformed(java.awt.event.ActionEvent evt) {
        String miktarStr = IslNakitAvansMiktariTextF.getText().trim();

        if (miktarStr.isEmpty()) return;

        try {
            double miktar = Double.parseDouble(miktarStr);

            // Service Katmanını Çağır
            String sonuc = Managers.BankService.nakitAvansCek(aktifKullanici.getUserId(), miktar);

            if (sonuc.equals("BASARILI")) {
                javax.swing.JOptionPane.showMessageDialog(this, "Nakit Avans Vadesiz Hesabınıza Aktarıldı!");

                // Bakiyeleri Güncelle
                anaSayfaGuncelle();
                hesaplariGuncelle();
                varliklariGuncelle();
                kartlariGuncelle(); // Limit düştüğü için bunu da güncelle
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, sonuc);
            }

        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Lütfen geçerli bir sayı giriniz.");
        }
    }

    private void KrediKartBorcOdeBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // 1. Güncel Borcu Çek
        model.CreditCard kart = Managers.DataBaseManager.getCreditCardObject(aktifKullanici.getUserId());

        if (kart != null) {
            // Formdaki Label'a borcu yaz
            KrediKartBorcGoruntulemeLabel.setText(String.format("Güncel Borcunuz: %,.2f TL", kart.getCurrentDebt()));

            // 2. Formu Hazırla ve Aç
            KrediKartBorcOdeForm.pack(); // Boyutları ayarla
            KrediKartBorcOdeForm.setLocationRelativeTo(this); // Merkeze al
            KrediKartBorcOdeForm.setVisible(true);
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Kredi kartınız bulunamadı.");
        }
    }

    private void KrediKartNakitAvansBtnActionPerformed(java.awt.event.ActionEvent evt) {
        mainSayfaDegistir("cardIslemlerPanel");
        panelAdiLabel.setText("İŞLEMLER");
        islemlerSayfaDegistir("cardIslNakitAvansPanel");
    }

    private void GuncelKurDovizIslemleriYonlendirmeBtnActionPerformed(java.awt.event.ActionEvent evt) {
        mainSayfaDegistir("cardIslemlerPanel");
        panelAdiLabel.setText("İŞLEMLER");
        islemlerSayfaDegistir("cardIslDovizPanel");
    }

    private void KrediKartBorcOdeFormBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // Kullanıcıdan ödeme miktarını al
        String miktarStr = javax.swing.JOptionPane.showInputDialog(KrediKartBorcOdeForm, "Ödemek istediğiniz tutarı giriniz:");

        if (miktarStr != null && !miktarStr.isEmpty()) {
            try {
                double miktar = Double.parseDouble(miktarStr);

                // BankService ile ödeme yap
                String sonuc = Managers.BankService.krediKartiBorcuOde(aktifKullanici.getUserId(), miktar);

                if (sonuc.equals("BASARILI")) {
                    javax.swing.JOptionPane.showMessageDialog(KrediKartBorcOdeForm, "Borç Ödeme Başarılı!");

                    // Tüm ekranları güncelle
                    kartlariGuncelle();
                    anaSayfaGuncelle();
                    varliklariGuncelle();

                    KrediKartBorcOdeForm.dispose(); // Formu kapat
                } else {
                    javax.swing.JOptionPane.showMessageDialog(KrediKartBorcOdeForm, sonuc);
                }
            } catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(KrediKartBorcOdeForm, "Geçersiz Tutar!");
            }
        }
    }

    private void UstPanelCıkısYapBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // 1. Kullanıcıya emin olup olmadığını soralım (İsteğe bağlı, güvenlik için iyidir)
        int secim = javax.swing.JOptionPane.showConfirmDialog(this,
                "Oturumu kapatmak istediğinize emin misiniz?",
                "Çıkış Yap",
                javax.swing.JOptionPane.YES_NO_OPTION);

        if (secim == javax.swing.JOptionPane.YES_OPTION) {
            // 2. Ana Menü ekranını (Login ekranını) tekrar aç
            MainMenuUI anaMenu = new MainMenuUI();
            anaMenu.setVisible(true);

            // 3. Mevcut ekranı (BireyselKullaniciUI) tamamen yok et/kapat
            this.dispose();
        }
    }

    private void FaturaOdeBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // 1. Tablodan seçili satırı al
        int selectedRow = FtrFaturalarimTable.getSelectedRow();

        if (selectedRow != -1) {
            // 2. Verileri al
            this.seciliFaturaId = FtrFaturalarimTable.getValueAt(selectedRow, 0).toString(); // ID'yi hafızaya al
            String hizmetAdi = FtrFaturalarimTable.getValueAt(selectedRow, 1).toString();
            String kurumAdi = FtrFaturalarimTable.getValueAt(selectedRow, 2).toString();
            String tutarStr = FtrFaturalarimTable.getValueAt(selectedRow, 3).toString();

            // Tutarı sayıya çevirip saklayalım (Kredi kartı limiti için lazım olabilir)
            try {
                this.seciliFaturaTutari = Double.parseDouble(tutarStr.replace(" TL", "").trim());
            } catch (Exception e) {
                this.seciliFaturaTutari = 0.0;
            }

            // 3. Pop-up Formu Doldur
            FaturaFirmaLabel.setText(kurumAdi + " - " + hizmetAdi);
            FaturaMiktariLabel.setText(tutarStr);

            // Radyo butonunu varsayılan olarak Banka Kartı yap
            FaturaBankaKartOdeRdBtn.setSelected(true);

            // 4. Formu Aç
            FaturaOdemeForm.pack();
            FaturaOdemeForm.setLocationRelativeTo(this);
            FaturaOdemeForm.setVisible(true);

        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Lütfen ödemek istediğiniz faturayı tablodan seçiniz.");
        }
    }

    private void FaturaOdemeOdeBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // KONSOL TAKİBİ - 1
        System.out.println("DEBUG: 'Öde' butonuna basıldı.");

        // Önce Fatura ID var mı kontrol et
        if (seciliFaturaId == null || seciliFaturaId.isEmpty()) {
            System.out.println("DEBUG HATA: Fatura ID boş! Seçim yapılmamış.");
            javax.swing.JOptionPane.showMessageDialog(FaturaOdemeForm, "Hata: Ödenecek fatura seçili değil.");
            return;
        }

        System.out.println("DEBUG: Seçilen Fatura ID: " + seciliFaturaId);

        // --- SEÇENEK 1: BANKA KARTI (VADESİZ HESAP) ---
        if (FaturaBankaKartOdeRdBtn.isSelected()) {
            System.out.println("DEBUG: Banka Kartı (Vadesiz Hesap) seçildi. Backend'e gidiliyor...");

            // Backend metodunu çağırıyoruz
            String sonuc = Managers.DataBaseManager.faturaOde(aktifKullanici.getUserId(), seciliFaturaId);

            // KONSOL TAKİBİ - 2 (En Kritik Yer)
            System.out.println("DEBUG: Backend'den dönen cevap: " + sonuc);

            if (sonuc.equals("BASARILI")) {
                System.out.println("DEBUG: İşlem Başarılı. Ekranlar yenileniyor.");
                islemiTamamla("Fatura Vadesiz Hesabınızdan Ödendi!");
            } else {
                System.out.println("DEBUG: İşlem Başarısız. Mesaj gösteriliyor.");
                javax.swing.JOptionPane.showMessageDialog(FaturaOdemeForm, sonuc);
            }
        }

        // --- SEÇENEK 2: KREDİ KARTI ---
        else if (FaturaKrediKartOdeRdBtn.isSelected()) {
            System.out.println("DEBUG: Kredi Kartı seçildi.");

            model.CreditCard kart = Managers.DataBaseManager.getCreditCardObject(aktifKullanici.getUserId());

            if (kart != null) {
                double kalanLimit = kart.getCreditLimit() - kart.getCurrentDebt();
                System.out.println("DEBUG: Kalan Limit: " + kalanLimit + " - Fatura Tutarı: " + seciliFaturaTutari);

                if (kalanLimit >= seciliFaturaTutari) {
                    // Kart Borcunu Artır
                    boolean kartGuncellendi = Managers.DataBaseManager.updateCardDebt(kart.getCardNumber(), (float)(kart.getCurrentDebt() + seciliFaturaTutari));

                    if (kartGuncellendi) {
                        System.out.println("DEBUG: Kart borcu güncellendi. Fatura kapatılıyor.");
                        Managers.DataBaseManager.depositToCompany(seciliFaturaId);
                        // Faturayı Kapat
                        Managers.DataBaseManager.markInvoiceAsPaidAndActivateService(seciliFaturaId);
                        islemiTamamla("Fatura Kredi Kartınızla Ödendi!");
                    } else {
                        System.out.println("DEBUG HATA: Kart güncelleme başarısız.");
                        javax.swing.JOptionPane.showMessageDialog(FaturaOdemeForm, "Kart işlemi sırasında hata oluştu.");
                    }
                } else {
                    System.out.println("DEBUG HATA: Yetersiz Limit.");
                    javax.swing.JOptionPane.showMessageDialog(FaturaOdemeForm, "Yetersiz Kredi Kartı Limiti!");
                }
            } else {
                System.out.println("DEBUG HATA: Kart bulunamadı.");
                javax.swing.JOptionPane.showMessageDialog(FaturaOdemeForm, "Kredi Kartınız bulunmamaktadır.");
            }
        }
    }

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new BireyselKullaniciUI(null).setVisible(true));
    }


    //=======Kendi özel fonksiyonlarım=========
    private void mainSayfaDegistir(String kartIsmi) {
        // 1. Kartı Değiştir
        java.awt.CardLayout layout = (java.awt.CardLayout) PanelContainer.getLayout();
        layout.show(PanelContainer, kartIsmi);
    }

    private void islemlerSayfaDegistir(String kartIsmi){
        java.awt.CardLayout subCardLayout = (java.awt.CardLayout) IslemlerPanelContainer.getLayout();
        subCardLayout.show(IslemlerPanelContainer, kartIsmi);
    }

    private void hesaplarSayfaDegistir(String kartIsmi){
        java.awt.CardLayout subCardLayout = (java.awt.CardLayout) HesaplarPanelContainer.getLayout();
        subCardLayout.show(HesaplarPanelContainer, kartIsmi);
    }

    private void faturalarSayfaDegistir(String kartIsmi){
        java.awt.CardLayout subCardLayout = (java.awt.CardLayout) FaturalarPanelContainer.getLayout();
        subCardLayout.show(FaturalarPanelContainer, kartIsmi);
    }


    // --- EKRANA VERİ BASAN METOTLAR ---

    // 1. İsim ve Müşteri No Göster (Üst Panel)
    private void kullaniciBilgileriniGoster() {
        if (aktifKullanici != null) {
            AdSoyadLabel.setText("Sn. " + aktifKullanici.getName() + " " + aktifKullanici.getSurname());
            MusteriNoLabel.setText("Müşteri No: " + aktifKullanici.getUserId());
        }
    }

    // 2. Ana Sayfa (Dashboard) Güncelleme
    private void anaSayfaGuncelle() {
        if (aktifKullanici != null) {
            // --- DEĞİŞİKLİK BURADA ---
            // Eskiden sadece bakiyeyi çekiyorduk (getVadesizTLBakiye).
            // Şimdi Hesaplar sayfasındaki gibi hem BAKİYE hem IBAN'ı "TL" koduyla çekiyoruz.
            String[] hesapBilgisi = Managers.DataBaseManager.getAccountDetails(aktifKullanici.getUserId(), "TL");

            double miktar = Double.parseDouble(hesapBilgisi[0]); // [0] Bakiye
            String iban = hesapBilgisi[1];                       // [1] IBAN

            AnaSayfaVadesizBakiyeLabel.setText(String.format("%,.2f TL", miktar));
            AnaSayfaVadesizIBANLabel.setText(iban); // <-- Artık gerçek IBAN yazıyor
            // -------------------------

            // Kredi Kartı Bilgileri (Aynı kaldı)
            double[] kartBilgisi = Managers.DataBaseManager.getCreditCardInfo(aktifKullanici.getUserId());
            double limit = kartBilgisi[0];
            double borc = kartBilgisi[1];
            double kullanilabilir = limit - borc;

            AnaSayfaKrdLimitLabel.setText(String.format("Limit: %,.2f TL", limit));
            AnaSayfaKrdBorcLabel.setText(String.format("Borç: %,.2f TL", borc));
            AnaSayfaKrdKullanılabilirLimitLabel.setText(String.format("Kullanılabilir: %,.2f TL", kullanilabilir));
        }
    }

    // --- HESAPLAR SAYFASINI GÜNCELLE (Senin CurrencyManager ile Uyumlu) ---
    private void hesaplariGuncelle() {
        if (aktifKullanici == null) return;
        String userId = aktifKullanici.getUserId();

        // ---------------------------------------------------------
        // 1. VADESİZ TL HESABI
        // ---------------------------------------------------------
        String[] tlDetay = Managers.DataBaseManager.getAccountDetails(userId, "TL");
        double tlMiktar = Double.parseDouble(tlDetay[0]);

        HspVadesizBakiyeLbl.setText(String.format("%,.2f TL", tlMiktar));
        HspVadesizIBANLbl.setText("IBAN: " + tlDetay[1]);

        // ---------------------------------------------------------
        // 2. DOLAR HESABI (USD)
        // ---------------------------------------------------------
        String[] usdDetay = Managers.DataBaseManager.getAccountDetails(userId, "USD");
        double usdMiktar = Double.parseDouble(usdDetay[0]);

        // Bakiyeyi yaz
        HspDovizDolarBakiyeLabel.setText(String.format("%,.2f $", usdMiktar));

        // TL Karşılığını Hesapla (Bankanın ALIŞ fiyatından hesaplıyoruz)
        // Senin kodunda: USD_BUY = 32.50
        double usdKur = Managers.CurrencyManager.getBuyRate("USD");
        double usdTlKarsiligi = usdMiktar * usdKur;

        HspDovizDolarTLLabel.setText(String.format("≈ %,.2f TL", usdTlKarsiligi));

        // ---------------------------------------------------------
        // 3. EURO HESABI (EUR)
        // ---------------------------------------------------------
        String[] eurDetay = Managers.DataBaseManager.getAccountDetails(userId, "EUR");
        double eurMiktar = Double.parseDouble(eurDetay[0]);

        HspDovizEuroBakiyeLabel.setText(String.format("%,.2f €", eurMiktar));

        // TL Karşılığı
        double eurKur = Managers.CurrencyManager.getBuyRate("EUR");
        double eurTlKarsiligi = eurMiktar * eurKur;

        HspDovizEuroTLLabel.setText(String.format("≈ %,.2f TL", eurTlKarsiligi));

        // ---------------------------------------------------------
        // 4. ALTIN HESABI (ALTIN / GOLD)
        // ---------------------------------------------------------
        // Veritabanında tür "ALTIN" olarak geçiyor, ama CurrencyManager'da "GOLD" istiyor.
        String[] altinDetay = Managers.DataBaseManager.getAccountDetails(userId, "ALTIN");
        double altinMiktar = Double.parseDouble(altinDetay[0]);

        HspDovizAltınBakiyeLabel.setText(String.format("%,.2f Gr", altinMiktar));

        // TL Karşılığı (Parametre olarak "GOLD" gönderiyoruz)
        double altinKur = Managers.CurrencyManager.getBuyRate("ALTIN");
        double altinTlKarsiligi = altinMiktar * altinKur;

        HspDovizAltınTLLabel.setText(String.format("≈ %,.2f TL", altinTlKarsiligi));
    }

    // --- VADELİ HESAP EKRANI YÖNETİMİ (Mantık Burada) ---
    private void vadeliHesapSayfasiniYonet() {
        if (aktifKullanici == null) return;

        java.util.ArrayList<String> hesapListesi = Managers.DataBaseManager.getVadeliAccountNames(aktifKullanici.getUserId());
        java.awt.CardLayout layout = (java.awt.CardLayout) HspVadeliPanel.getLayout();

        if (hesapListesi.isEmpty()) {
            layout.show(HspVadeliPanel, "cardHspVadeliYokPanel");
        } else {
            layout.show(HspVadeliPanel, "cardHspVadeliVarPanel");

            // --- BU KISMI EKLE: LABELLARI TAMAMEN GİZLE ---
            HspVadeliTürüLbl.setVisible(false);
            HspVadeliYatirilanTutarLbl.setVisible(false);
            HspVadeliKalanGunLbl.setVisible(false);
            HspVadeliKalanGetirisiLbl.setVisible(false);
            jLabel22.setVisible(false);
            jLabel23.setVisible(false);
            jLabel24.setVisible(false);
            jLabel25.setVisible(false);
            // ----------------------------------------------

            HspVadeliListComboBox.removeAllItems();
            for (String hesapAdi : hesapListesi) {
                HspVadeliListComboBox.addItem(hesapAdi);
            }
        }
    }


    // =========================================================================
    // 5. YENİ İŞLEM MANTIKLARI (LOGIC) - BURAYI KOPYALA
    // =========================================================================

    // --- A. DÖVİZ KURLARINI EKRANA BASMA ---
    private void dovizKurlariniEkranaYaz() {
        // Dolar
        IslDovizDolarAlısKur.setText(String.valueOf(Managers.CurrencyManager.getUsdBuy()));
        IslDovizDolarSatısKur.setText(String.valueOf(Managers.CurrencyManager.getUsdSell()));

        // Euro
        IslDovizEuroAlısKur.setText(String.valueOf(Managers.CurrencyManager.getEurBuy()));
        IslDovizEuroSatısKur.setText(String.valueOf(Managers.CurrencyManager.getEurSell()));

        // Altın
        IslDovizAltinAlısKur.setText(String.valueOf(Managers.CurrencyManager.getGauBuy()));
        IslDovizAltinSatisKur.setText(String.valueOf(Managers.CurrencyManager.getGauSell()));
    }

    // --- E. DÖVİZ İŞLEMLERİ (ORTAK METOT) ---
    private void dovizIslemiYap(String tur, javax.swing.JTextField alText, javax.swing.JTextField satText, javax.swing.JRadioButton rAl, javax.swing.JRadioButton rSat) {
        String currencyCode = "";
        if (tur.equals("DOLAR")) currencyCode = "USD";
        else if (tur.equals("EURO")) currencyCode = "EUR";
        else if (tur.equals("ALTIN")) currencyCode = "ALTIN";

        try {
            // 1. Gerekli Nesneleri Oluştur
            model.CheckingAccount tlAccount = Managers.DataBaseManager.getCheckingAccountObject(aktifKullanici.getUserId());
            model.ForeignCurrencyAccount forexAccount = Managers.DataBaseManager.getForeignCurrencyAccountObject(aktifKullanici.getUserId(), currencyCode);

            if (tlAccount == null || forexAccount == null) {
                javax.swing.JOptionPane.showMessageDialog(this, "Hesap bilgilerine ulaşılamadı.");
                return;
            }

            // --- ALIŞ İŞLEMİ ---
            if (rAl.isSelected()) {
                double tlAmount = Double.parseDouble(alText.getText().trim());

                boolean success = forexAccount.buyCurrency(tlAccount, tlAmount);

                if(success) {
                    javax.swing.JOptionPane.showMessageDialog(this, tur + " Alışı Başarılı!");

                    // --- EKRANLARI YENİLE ---
                    hesaplariGuncelle();
                    anaSayfaGuncelle();
                    varliklariGuncelle(); // <--- YENİ EKLENEN SATIR (Varlıkları Günceller)
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "Yetersiz TL Bakiyesi!");
                }
            }
            // --- SATIŞ İŞLEMİ ---
            else if (rSat.isSelected()) {
                double forexAmount = Double.parseDouble(satText.getText().trim());

                boolean success = forexAccount.sellCurrency(tlAccount, forexAmount);

                if(success) {
                    javax.swing.JOptionPane.showMessageDialog(this, tur + " Satışı Başarılı!");

                    // --- EKRANLARI YENİLE ---
                    hesaplariGuncelle();
                    anaSayfaGuncelle();
                    varliklariGuncelle(); // <--- YENİ EKLENEN SATIR (Varlıkları Günceller)
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "Yetersiz Döviz Bakiyesi!");
                }
            }

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Hata: " + e.getMessage());
        }
    }

    // =============================================================
    // KART BİLGİLERİNİ EKRANA YAZAN METOT
    // =============================================================
    private void kartlariGuncelle() {
        if (aktifKullanici == null) return;
        String userId = aktifKullanici.getUserId();

        // --- 1. BANKA KARTI (DEBIT CARD) GÜNCELLEME ---
        model.DebitCard bankaKarti = Managers.DataBaseManager.getDebitCardObject(userId);

        if (bankaKarti != null) {
            // Kart Bilgileri (Parent Class 'Card'dan gelenler)
            BankaKartNoLabel.setText(bankaKarti.getCardNumber());
            BankaKartAdSoyadLabel.setText(aktifKullanici.getName() + " " + aktifKullanici.getSurname());
            BankaKartSKTLabel.setText(bankaKarti.getExpiryDate());
            BankaKartCVVLabel.setText(bankaKarti.getCvv());

            // Bakiye (Bağlı olduğu hesaptan çekiyoruz)
            if (bankaKarti.getLinkedAccount() != null) {
                double bakiye = bankaKarti.getLinkedAccount().getMoneyInAccount();
                BankaKartBakiye.setText(String.format("%,.2f TL", bakiye));
            } else {
                BankaKartBakiye.setText("Bağlantı Hatası");
            }
        } else {
            // Kart Yoksa
            BankaKartNoLabel.setText("BANKA KARTINIZ YOK");
            BankaKartBakiye.setText("---");
            BankaKartSKTLabel.setText("--/--");
            BankaKartCVVLabel.setText("---");
        }

        // --- 2. KREDİ KARTI (CREDIT CARD) GÜNCELLEME ---
        model.CreditCard krediKarti = Managers.DataBaseManager.getCreditCardObject(userId);

        if (krediKarti != null) {
            // Temel Bilgiler
            KrediKartNoLabel.setText(krediKarti.getCardNumber());
            KrediKartAdSoyadLabel.setText(aktifKullanici.getName() + " " + aktifKullanici.getSurname());
            KrediKartSKTLabel.setText(krediKarti.getExpiryDate());
            KrediKartCVVLabel.setText(krediKarti.getCvv());

            // Finansal Bilgiler
            double limit = krediKarti.getCreditLimit();
            double borc = krediKarti.getCurrentDebt();
            double kullanilabilir = limit - borc;

            KrediKartLimitLabel.setText(String.format("%,.2f TL", limit));
            KrediKartBorcLabel.setText(String.format("%,.2f TL", borc));
            KrediKartKullanılabilirBakiyeLabel.setText(String.format("%,.2f TL", kullanilabilir));

        } else {
            // Kart Yoksa
            KrediKartNoLabel.setText("KREDİ KARTINIZ YOK");
            KrediKartLimitLabel.setText("---");
            KrediKartBorcLabel.setText("---");
        }
    }

    // --- A. VARLIKLARIMI GÜNCELLE ---
    private void varliklariGuncelle() {
        if (aktifKullanici == null) return;
        String userId = aktifKullanici.getUserId();

        // 1. TL Varlığı (Vadesiz + Varsa Vadeli Toplamı)
        // Basitlik için şu an sadece Vadesiz TL'yi çekiyoruz, istersen vadeli de eklenebilir.
        String[] tlDetay = Managers.DataBaseManager.getAccountDetails(userId, "TL");
        double tlMiktar = Double.parseDouble(tlDetay[0]);
        VarliklarTLLabel.setText(String.format("%,.2f TL", tlMiktar));

        // 2. Dolar Varlığı
        String[] usdDetay = Managers.DataBaseManager.getAccountDetails(userId, "USD");
        double usdMiktar = Double.parseDouble(usdDetay[0]);
        VarliklarDolarLabel.setText(String.format("%,.2f $", usdMiktar));

        // 3. Euro Varlığı
        String[] eurDetay = Managers.DataBaseManager.getAccountDetails(userId, "EUR");
        double eurMiktar = Double.parseDouble(eurDetay[0]);
        VarliklarEuroLabel.setText(String.format("%,.2f €", eurMiktar));

        // 4. Altın Varlığı
        String[] altinDetay = Managers.DataBaseManager.getAccountDetails(userId, "ALTIN");
        double altinMiktar = Double.parseDouble(altinDetay[0]);
        VarliklarAltinLabel.setText(String.format("%,.2f Gr", altinMiktar));
    }

    // --- B. GÜNCEL KURLARI GÜNCELLE ---
    private void guncelKurlariGuncelle() {
        GuncelKurDolarAlısLabel.setText("Dolar Alış: " + Managers.CurrencyManager.getUsdBuy());
        GuncelKurDolarSatısLabel.setText("Dolar Satış: " + Managers.CurrencyManager.getUsdSell());

        GuncelKurEuroAlısLabel.setText("Euro Alış: " + Managers.CurrencyManager.getEurBuy());
        GuncelKurEuroSatisLabel.setText("Euro Satış: " + Managers.CurrencyManager.getEurSell());

        GuncelKurAltinAlısLabel.setText("Altın Alış: " + Managers.CurrencyManager.getGauBuy());
        GuncelKurAltinSatisLabel.setText("Altın Satış: " + Managers.CurrencyManager.getGauSell());
    }

    // --- C. İŞLEMLER SAYFASINDAKİ VADELİ HESAP BİLGİSİ ---
    private void vadeliIslemBilgisiniGuncelle() {
        if (aktifKullanici == null) return;

        java.util.ArrayList<String> hesaplar = Managers.DataBaseManager.getVadeliAccountNames(aktifKullanici.getUserId());
        int sayi = hesaplar.size();

        if (sayi > 0) {
            IslVadeliHesapBilgilendirmeLabel.setText(sayi + " adet vadeli hesabınız bulunmaktadır.");
            IslVadeliVadeliHesapGormeBtn.setVisible(true); // Butonu Göster
        } else {
            IslVadeliHesapBilgilendirmeLabel.setText("Hiç vadeli hesabınız bulunmamaktadır.");
            IslVadeliVadeliHesapGormeBtn.setVisible(false); // Butonu Gizle
        }
    }

    // =============================================================
    // ABONELİK VE FATURA TABLO YÖNETİMİ
    // =============================================================

    // 1. Abonelikler Tablosunu Doldur
    private void abonelikleriGuncelle() {
        if (aktifKullanici == null) return;

        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) FtrAboneliklerimTable.getModel();
        model.setRowCount(0); // Tabloyu temizle
        model.setColumnIdentifiers(new String[]{"Hizmet", "Kurum", "Tutar", "Kesim Dönemi"});

        // Manager'dan veriyi çek
        java.util.ArrayList<String[]> liste = Managers.DataBaseManager.getBireyselAbonelikler(aktifKullanici.getTcNo());

        for (String[] satir : liste) {
            model.addRow(satir);
        }
    }

    // 2. Faturalar Tablosunu Doldur
    private void faturalariGuncelle() {
        if (aktifKullanici == null) return;

        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) FtrFaturalarimTable.getModel();
        model.setRowCount(0);
        // Sütunlar: [0]FaturaID(Gizli), [1]Hizmet, [2]Kurum, [3]Tutar, [4]Son Ödeme
        model.setColumnIdentifiers(new String[]{"Fatura No", "Hizmet", "Kurum", "Tutar", "Son Ödeme Tarihi"});

        java.util.ArrayList<String[]> liste = Managers.DataBaseManager.getBireyselFaturalar(aktifKullanici.getTcNo());

        for (String[] satir : liste) {
            model.addRow(satir);
        }
    }

    // İşlem Sonrası Ekranları Yenileme Metodu
    private void islemiTamamla(String mesaj) {
        javax.swing.JOptionPane.showMessageDialog(FaturaOdemeForm, mesaj);
        FaturaOdemeForm.dispose(); // Pencereyi kapat

        // Tüm ekranları yenile
        faturalariGuncelle();
        anaSayfaGuncelle();
        hesaplariGuncelle();
        varliklariGuncelle();
        kartlariGuncelle();
    }

    private void dovizInputlariniDuzenle() {
        // Genişlik: 140px, Yükseklik: 35px olarak ayarlıyoruz
        java.awt.Dimension inputBoyutu = new java.awt.Dimension(68, 33);

        // Dolar Kutuları
        IslAlınacakDolarMiktariTextF.setPreferredSize(inputBoyutu);
        IslSatilacakDolarMiktariTextF.setPreferredSize(inputBoyutu);

        // Euro Kutuları
        IslAlınacakEuroMiktariTextF.setPreferredSize(inputBoyutu);
        IslSatilacakEuroMiktariTextF.setPreferredSize(inputBoyutu);

        // Altın Kutuları
        IslAlınacakAltınMiktariTextF.setPreferredSize(inputBoyutu);
        IslSatılacakAlMiktariTextF.setPreferredSize(inputBoyutu);
    }

    // Variables declaration - do not modify
    private javax.swing.JLabel AdSoyadLabel;
    private javax.swing.JRadioButton AltinAlRadioBtn;
    private javax.swing.ButtonGroup AltinIslemleri;
    private javax.swing.JRadioButton AltinSatRadioBtn;
    private javax.swing.JButton AnaSayfaBorcOdeBtn;
    private javax.swing.JButton AnaSayfaBtn;
    private javax.swing.JLabel AnaSayfaKrdBorcLabel;
    private javax.swing.JLabel AnaSayfaKrdKullanılabilirLimitLabel;
    private javax.swing.JLabel AnaSayfaKrdLimitLabel;
    private javax.swing.JPanel AnaSayfaKrediKartiPanel;
    private javax.swing.JPanel AnaSayfaPanel;
    private javax.swing.JLabel AnaSayfaVadesizBakiyeLabel;
    private javax.swing.JPanel AnaSayfaVadesizHesapPanel;
    private javax.swing.JLabel AnaSayfaVadesizIBANLabel;
    private javax.swing.JLabel BankaKartAdSoyadLabel;
    private javax.swing.JLabel BankaKartBakiye;
    private javax.swing.JLabel BankaKartCVVLabel;
    private javax.swing.JLabel BankaKartNoLabel;
    private javax.swing.JLabel BankaKartSKTLabel;
    private javax.swing.JRadioButton DolarAlRadioBtn;
    private javax.swing.ButtonGroup DolarIslemleri;
    private javax.swing.JRadioButton DolarSatRadioBtn;
    private javax.swing.JRadioButton EuroAlRadioBtn;
    private javax.swing.ButtonGroup EuroIslemleri;
    private javax.swing.JRadioButton EuroSatRadioBtn;
    private javax.swing.JRadioButton FaturaBankaKartOdeRdBtn;
    private javax.swing.JLabel FaturaFirmaLabel;
    private javax.swing.JRadioButton FaturaKrediKartOdeRdBtn;
    private javax.swing.JLabel FaturaMiktariLabel;
    private javax.swing.JButton FaturaOdeBtn;
    private javax.swing.JFrame FaturaOdemeForm;
    private javax.swing.ButtonGroup FaturaOdemeKartTuru;
    private javax.swing.JButton FaturaOdemeOdeBtn;
    private javax.swing.JPanel FaturaOdemePanel;
    private javax.swing.JButton FaturalarBtn;
    private javax.swing.JPanel FaturalarPanel;
    private javax.swing.JPanel FaturalarPanelContainer;
    private javax.swing.JButton FtrAboneliklerimBtn;
    private javax.swing.JPanel FtrAboneliklerimPanel;
    private javax.swing.JTable FtrAboneliklerimTable;
    private javax.swing.JTable FtrFaturalarimTable;
    private javax.swing.JScrollPane FtrFaturalarimTables;
    private javax.swing.JButton FtrFaturalarımBtn;
    private javax.swing.JPanel FtrFaturalarımPanel;
    private javax.swing.JButton GonderBtn;
    private javax.swing.JTextField GonderilecekAdTextF;
    private javax.swing.JTextField GonderilecekIBANTextF;
    private javax.swing.JTextField GonderilecekMiktarTextF;
    private javax.swing.JTextField GonderilecekSoyadTextF;
    private javax.swing.JLabel GuncelKurAltinAlısLabel;
    private javax.swing.JLabel GuncelKurAltinSatisLabel;
    private javax.swing.JButton GuncelKurBtn;
    private javax.swing.JLabel GuncelKurDolarAlısLabel;
    private javax.swing.JLabel GuncelKurDolarSatısLabel;
    private javax.swing.JButton GuncelKurDovizIslemleriYonlendirmeBtn;
    private javax.swing.JLabel GuncelKurEuroAlısLabel;
    private javax.swing.JLabel GuncelKurEuroSatisLabel;
    private javax.swing.JPanel GuncelKurPanel;
    private javax.swing.JButton HesaplarBtn;
    private javax.swing.JPanel HesaplarPanel;
    private javax.swing.JPanel HesaplarPanelContainer;
    private javax.swing.JLabel HspDovizAltınBakiyeLabel;
    private javax.swing.JLabel HspDovizAltınTLLabel;
    private javax.swing.JLabel HspDovizDolarBakiyeLabel;
    private javax.swing.JLabel HspDovizDolarTLLabel;
    private javax.swing.JLabel HspDovizEuroBakiyeLabel;
    private javax.swing.JLabel HspDovizEuroTLLabel;
    private javax.swing.JButton HspDovizIslemleriBtn;
    private javax.swing.JPanel HspDovizPanel;
    private javax.swing.JButton HspDövizBtn;
    private javax.swing.JButton HspVadeliAcBtn;
    private javax.swing.JButton HspVadeliBtn;
    private javax.swing.JLabel HspVadeliKalanGetirisiLbl;
    private javax.swing.JLabel HspVadeliKalanGunLbl;
    private javax.swing.JComboBox<String> HspVadeliListComboBox;
    private javax.swing.JPanel HspVadeliPanel;
    private javax.swing.JLabel HspVadeliTürüLbl;
    private javax.swing.JPanel HspVadeliVarPanel;
    private javax.swing.JLabel HspVadeliYatirilanTutarLbl;
    private javax.swing.JButton HspVadeliYeniHesapBtn;
    private javax.swing.JPanel HspVadeliYokPanel;
    private javax.swing.JLabel HspVadesizBakiyeLbl;
    private javax.swing.JButton HspVadesizBtn;
    private javax.swing.JButton HspVadesizFaturaOdeBtn;
    private javax.swing.JLabel HspVadesizIBANLbl;
    private javax.swing.JPanel HspVadesizPanel;
    private javax.swing.JButton HspVadesizParaTrnsfrBtn;
    private javax.swing.JTextField IslAlınacakAltınMiktariTextF;
    private javax.swing.JTextField IslAlınacakDolarMiktariTextF;
    private javax.swing.JTextField IslAlınacakEuroMiktariTextF;
    private javax.swing.JLabel IslDovizAltinAlısKur;
    private javax.swing.JButton IslDovizAltinIslemi;
    private javax.swing.JLabel IslDovizAltinSatisKur;
    private javax.swing.JButton IslDovizBtn;
    private javax.swing.JLabel IslDovizDolarAlısKur;
    private javax.swing.JButton IslDovizDolarIslemi;
    private javax.swing.JLabel IslDovizDolarSatısKur;
    private javax.swing.JLabel IslDovizEuroAlısKur;
    private javax.swing.JButton IslDovizEuroIslemi;
    private javax.swing.JLabel IslDovizEuroSatısKur;
    private javax.swing.JPanel IslDovizPanel;
    private javax.swing.JButton IslNakitAvansGonderBtn;
    private javax.swing.JTextField IslNakitAvansMiktariTextF;
    private javax.swing.JPanel IslNakitAvansPanel;
    private javax.swing.JButton IslNakitAvansPanelBtn;
    private javax.swing.JButton IslParaGönderBtn;
    private javax.swing.JPanel IslParaGönderPanel;
    private javax.swing.JTextField IslSatilacakDolarMiktariTextF;
    private javax.swing.JTextField IslSatilacakEuroMiktariTextF;
    private javax.swing.JTextField IslSatılacakAlMiktariTextF;
    private javax.swing.JComboBox<String> IslVadeSecenekleriComboBox;
    private javax.swing.JTextField IslVadeYatirilacakMiktarTextF;
    private javax.swing.JLabel IslVadeliBilgilendirmeLabel;
    private javax.swing.JPanel IslVadeliBilgilendirmePanel;
    private javax.swing.JButton IslVadeliBtn;
    private javax.swing.JTextField IslVadeliHesapAdlandirmaTextF;
    private javax.swing.JLabel IslVadeliHesapBilgilendirmeLabel;
    private javax.swing.JButton IslVadeliHesapOlustur;
    private javax.swing.JButton IslVadeliHesapOnizle;
    private javax.swing.JLabel IslVadeliKazancLabel;
    private javax.swing.JPanel IslVadeliPanel;
    private javax.swing.JButton IslVadeliVadeliHesapGormeBtn;
    private javax.swing.JButton IslemlerBtn;
    private javax.swing.JPanel IslemlerPanel;
    private javax.swing.JPanel IslemlerPanelContainer;
    private javax.swing.JButton KartlarBtn;
    private javax.swing.JPanel KartlarPanel;
    private javax.swing.JLabel KrediKartAdSoyadLabel;
    private javax.swing.JLabel KrediKartBorcGoruntulemeLabel;
    private javax.swing.JLabel KrediKartBorcLabel;
    private javax.swing.JButton KrediKartBorcOdeBtn;
    private javax.swing.JFrame KrediKartBorcOdeForm;
    private javax.swing.JButton KrediKartBorcOdeFormBtn;
    private javax.swing.JPanel KrediKartBorcOdePanel;
    private javax.swing.JLabel KrediKartCVVLabel;
    private javax.swing.JLabel KrediKartKullanılabilirBakiyeLabel;
    private javax.swing.JLabel KrediKartLimitLabel;
    private javax.swing.JButton KrediKartNakitAvansBtn;
    private javax.swing.JLabel KrediKartNoLabel;
    private javax.swing.JLabel KrediKartSKTLabel;
    private javax.swing.JPanel KrtBankaKartiPanel;
    private javax.swing.JPanel KrtKrediKartiPanel;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JLabel MusteriNoLabel;
    private javax.swing.JPanel PanelContainer;
    private javax.swing.JPanel UstPanel;
    private javax.swing.JButton UstPanelCıkısYapBtn;
    private javax.swing.JLabel VarliklarAltinLabel;
    private javax.swing.JButton VarliklarBtn;
    private javax.swing.JLabel VarliklarDolarLabel;
    private javax.swing.JLabel VarliklarEuroLabel;
    private javax.swing.JPanel VarliklarPanel;
    private javax.swing.JLabel VarliklarTLLabel;
    private javax.swing.JPanel YonlendirmePanel;
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label12;
    private javax.swing.JLabel label13;
    private javax.swing.JLabel label14;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl10;
    private javax.swing.JLabel lbl11;
    private javax.swing.JLabel lbl12;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl6;
    private javax.swing.JLabel lbl7;
    private javax.swing.JLabel lbl8;
    private javax.swing.JLabel lbl9;
    private javax.swing.JLabel panelAdiLabel;
    // End of variables declaration
}

package UI;

public class BireyselKullaniciUI extends javax.swing.JFrame {

    private model.IndividualUser aktifKullanici;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(BireyselKullaniciUI.class.getName());


    public BireyselKullaniciUI(model.IndividualUser user) {
        this.aktifKullanici = user;
        initComponents();

        // Başlangıçta Ana Sayfa Açık
        panelAdiLabel.setText("ANA SAYFA");

        // Verileri Veritabanından Çek ve Doldur
        kullaniciBilgileriniGoster();
        anaSayfaGuncelle();    // Dashboard Bakiyesi ve Kredi Kartı
        hesaplariGuncelle();   // Hesaplar Sekmesindeki (Vadesiz, Döviz) veriler
        dovizKurlariniEkranaYaz();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        DolarIslemleri = new javax.swing.ButtonGroup();
        EuroIslemleri = new javax.swing.ButtonGroup();
        AltinIslemleri = new javax.swing.ButtonGroup();
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
        MusteriNoLabel = new javax.swing.JLabel();
        panelAdiLabel = new javax.swing.JLabel();
        lbl8 = new javax.swing.JLabel();
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
        IslBilgiPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        IslParaGönderPanel = new javax.swing.JPanel();
        GonderilecekAdTextF = new javax.swing.JTextField();
        GonderilecekSoyadTextF = new javax.swing.JTextField();
        GonderilecekIBANTextF = new javax.swing.JTextField();
        GonderilecekMiktarTextF = new javax.swing.JTextField();
        GonderBtn = new javax.swing.JButton();
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
        IslDovizDolarIslemi = new javax.swing.JToggleButton();
        IslDovizEuroIslemi = new javax.swing.JToggleButton();
        IslDovizAltinIslemi = new javax.swing.JToggleButton();
        DolarAlRadioBtn = new javax.swing.JRadioButton();
        DolarSatRadioBtn = new javax.swing.JRadioButton();
        EuroAlRadioBtn = new javax.swing.JRadioButton();
        EuroSatRadioBtn = new javax.swing.JRadioButton();
        AltinAlRadioBtn = new javax.swing.JRadioButton();
        AltinSatRadioBtn = new javax.swing.JRadioButton();
        IslParaGönderBtn = new javax.swing.JButton();
        IslVadeliBtn = new javax.swing.JButton();
        IslDovizBtn = new javax.swing.JButton();
        IslBilgiPanelBtn = new javax.swing.JButton();
        HesaplarPanel = new javax.swing.JPanel();
        HesaplarPanelContainer = new javax.swing.JPanel();
        HspVadesizPanel = new javax.swing.JPanel();
        HspVadesizBakiyeLbl = new javax.swing.JLabel();
        HspVadesizIBANLbl = new javax.swing.JLabel();
        HspVadesizParaTrnsfrBtn = new javax.swing.JButton();
        HspVadesizFaturaOdeBtn = new javax.swing.JButton();
        HspVadeliPanel = new javax.swing.JPanel();
        HspVadeliYokPanel = new javax.swing.JPanel();
        lbl9 = new javax.swing.JLabel();
        HspVadeliAcBtn = new javax.swing.JButton();
        HspVadeliVarPanel = new javax.swing.JPanel();
        HspVadeliListComboBox = new javax.swing.JComboBox<>();
        HspVadeliTürüLbl = new javax.swing.JLabel();
        HspVadeliYatirilanTutarLbl = new javax.swing.JLabel();
        HspVadeliKalanGunLbl = new javax.swing.JLabel();
        HspVadeliKalanGetirisiLbl = new javax.swing.JLabel();
        HspVadeliYeniHesapBtn = new javax.swing.JButton();
        HspDovizPanel = new javax.swing.JPanel();
        HspDovizDolarBakiyeLabel = new javax.swing.JLabel();
        HspDovizEuroBakiyeLabel = new javax.swing.JLabel();
        HspDovizAltınBakiyeLabel = new javax.swing.JLabel();
        HspDovizDolarTLLabel = new javax.swing.JLabel();
        HspDovizEuroTLLabel = new javax.swing.JLabel();
        HspDovizAltınTLLabel = new javax.swing.JLabel();
        HspDovizIslemleriBtn = new javax.swing.JButton();
        HspVadesizBtn = new javax.swing.JButton();
        HspVadeliBtn = new javax.swing.JButton();
        HspDövizBtn = new javax.swing.JButton();
        KartlarPanel = new javax.swing.JPanel();
        KrtBankaKartiPanel = new javax.swing.JPanel();
        lbl6 = new javax.swing.JLabel();
        KrtKrediKartiPanel = new javax.swing.JPanel();
        lbl7 = new javax.swing.JLabel();
        FaturalarPanel = new javax.swing.JPanel();
        FtrAboneliklerimBtn = new javax.swing.JButton();
        FtrFaturalarımBtn = new javax.swing.JButton();
        FaturalarPanelContainer = new javax.swing.JPanel();
        FtrAboneliklerimPanel = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        FtrFaturalarımPanel = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        VarliklarPanel = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        GuncelKurPanel = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        AnaSayfaBtn.setText("jButton1");
        AnaSayfaBtn.addActionListener(this::AnaSayfaBtnActionPerformed);

        IslemlerBtn.setText("jButton2");
        IslemlerBtn.addActionListener(this::IslemlerBtnActionPerformed);

        HesaplarBtn.setText("jButton2");
        HesaplarBtn.addActionListener(this::HesaplarBtnActionPerformed);

        KartlarBtn.setText("jButton2");
        KartlarBtn.addActionListener(this::KartlarBtnActionPerformed);

        FaturalarBtn.setText("jButton2");
        FaturalarBtn.addActionListener(this::FaturalarBtnActionPerformed);

        VarliklarBtn.setText("jButton2");
        VarliklarBtn.addActionListener(this::VarliklarBtnActionPerformed);

        GuncelKurBtn.setText("jButton2");
        GuncelKurBtn.addActionListener(this::GuncelKurBtnActionPerformed);

        javax.swing.GroupLayout YonlendirmePanelLayout = new javax.swing.GroupLayout(YonlendirmePanel);
        YonlendirmePanel.setLayout(YonlendirmePanelLayout);
        YonlendirmePanelLayout.setHorizontalGroup(
                YonlendirmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(YonlendirmePanelLayout.createSequentialGroup()
                                .addGap(266, 266, 266)
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

        AdSoyadLabel.setText("Ad Soyad");

        MusteriNoLabel.setText("MusteriNo");

        panelAdiLabel.setText("panelAdi");

        lbl8.setText("DİNO BANK");

        javax.swing.GroupLayout UstPanelLayout = new javax.swing.GroupLayout(UstPanel);
        UstPanel.setLayout(UstPanelLayout);
        UstPanelLayout.setHorizontalGroup(
                UstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(UstPanelLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(AdSoyadLabel)
                                .addGap(388, 388, 388)
                                .addGroup(UstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                        .addComponent(panelAdiLabel)
                                        .addComponent(lbl8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(MusteriNoLabel)
                                .addGap(22, 22, 22))
        );
        UstPanelLayout.setVerticalGroup(
                UstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(UstPanelLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(UstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(AdSoyadLabel)
                                        .addComponent(MusteriNoLabel))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UstPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelAdiLabel)
                                .addGap(16, 16, 16))
        );

        PanelContainer.setLayout(new java.awt.CardLayout());

        lbl1.setText("Vadesiz Hesap");

        AnaSayfaVadesizBakiyeLabel.setText("Bakiye");

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
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        lbl2.setText("Kredi Kartı");

        AnaSayfaKrdLimitLabel.setText("Kart Limit");

        AnaSayfaKrdKullanılabilirLimitLabel.setText("Kullanılabilir Limit");

        AnaSayfaKrdBorcLabel.setText("Güncel Borç");

        AnaSayfaBorcOdeBtn.setText("Borç Öde");

        javax.swing.GroupLayout AnaSayfaKrediKartiPanelLayout = new javax.swing.GroupLayout(AnaSayfaKrediKartiPanel);
        AnaSayfaKrediKartiPanel.setLayout(AnaSayfaKrediKartiPanelLayout);
        AnaSayfaKrediKartiPanelLayout.setHorizontalGroup(
                AnaSayfaKrediKartiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(AnaSayfaKrediKartiPanelLayout.createSequentialGroup()
                                .addGroup(AnaSayfaKrediKartiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(AnaSayfaKrediKartiPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(lbl2))
                                        .addGroup(AnaSayfaKrediKartiPanelLayout.createSequentialGroup()
                                                .addGap(52, 52, 52)
                                                .addGroup(AnaSayfaKrediKartiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(AnaSayfaKrediKartiPanelLayout.createSequentialGroup()
                                                                .addComponent(AnaSayfaKrdKullanılabilirLimitLabel)
                                                                .addGap(222, 222, 222)
                                                                .addComponent(AnaSayfaBorcOdeBtn))
                                                        .addComponent(AnaSayfaKrdLimitLabel)
                                                        .addComponent(AnaSayfaKrdBorcLabel))))
                                .addContainerGap(303, Short.MAX_VALUE))
        );
        AnaSayfaKrediKartiPanelLayout.setVerticalGroup(
                AnaSayfaKrediKartiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(AnaSayfaKrediKartiPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbl2)
                                .addGap(31, 31, 31)
                                .addComponent(AnaSayfaKrdLimitLabel)
                                .addGroup(AnaSayfaKrediKartiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(AnaSayfaKrediKartiPanelLayout.createSequentialGroup()
                                                .addGap(29, 29, 29)
                                                .addComponent(AnaSayfaKrdKullanılabilirLimitLabel))
                                        .addGroup(AnaSayfaKrediKartiPanelLayout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(AnaSayfaBorcOdeBtn)))
                                .addGap(18, 18, 18)
                                .addComponent(AnaSayfaKrdBorcLabel)
                                .addContainerGap(71, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout AnaSayfaPanelLayout = new javax.swing.GroupLayout(AnaSayfaPanel);
        AnaSayfaPanel.setLayout(AnaSayfaPanelLayout);
        AnaSayfaPanelLayout.setHorizontalGroup(
                AnaSayfaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(AnaSayfaPanelLayout.createSequentialGroup()
                                .addGap(168, 168, 168)
                                .addGroup(AnaSayfaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(AnaSayfaKrediKartiPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(AnaSayfaVadesizHesapPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(87, Short.MAX_VALUE))
        );
        AnaSayfaPanelLayout.setVerticalGroup(
                AnaSayfaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(AnaSayfaPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(AnaSayfaVadesizHesapPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(AnaSayfaKrediKartiPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(13, Short.MAX_VALUE))
        );

        PanelContainer.add(AnaSayfaPanel, "cardAnaSayfaPanel");

        IslemlerPanelContainer.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        IslemlerPanelContainer.setLayout(new java.awt.CardLayout());

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout IslBilgiPanelLayout = new javax.swing.GroupLayout(IslBilgiPanel);
        IslBilgiPanel.setLayout(IslBilgiPanelLayout);
        IslBilgiPanelLayout.setHorizontalGroup(
                IslBilgiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(IslBilgiPanelLayout.createSequentialGroup()
                                .addGap(355, 355, 355)
                                .addComponent(jLabel1)
                                .addContainerGap(319, Short.MAX_VALUE))
        );
        IslBilgiPanelLayout.setVerticalGroup(
                IslBilgiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, IslBilgiPanelLayout.createSequentialGroup()
                                .addContainerGap(217, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(235, 235, 235))
        );

        IslemlerPanelContainer.add(IslBilgiPanel, "cardIslBilgiPanel");

        GonderilecekAdTextF.setText("jTextField1");

        GonderilecekSoyadTextF.setText("jTextField1");

        GonderilecekIBANTextF.setText("jTextField1");

        GonderilecekMiktarTextF.setText("jTextField1");

        GonderBtn.setText("Gönder");
        GonderBtn.addActionListener(this::GonderBtnActionPerformed);

        javax.swing.GroupLayout IslParaGönderPanelLayout = new javax.swing.GroupLayout(IslParaGönderPanel);
        IslParaGönderPanel.setLayout(IslParaGönderPanelLayout);
        IslParaGönderPanelLayout.setHorizontalGroup(
                IslParaGönderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(IslParaGönderPanelLayout.createSequentialGroup()
                                .addGap(290, 290, 290)
                                .addGroup(IslParaGönderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(GonderilecekAdTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(GonderilecekSoyadTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(GonderilecekIBANTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(IslParaGönderPanelLayout.createSequentialGroup()
                                                .addComponent(GonderilecekMiktarTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(119, 119, 119)
                                                .addComponent(GonderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(90, Short.MAX_VALUE))
        );
        IslParaGönderPanelLayout.setVerticalGroup(
                IslParaGönderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(IslParaGönderPanelLayout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(GonderilecekAdTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67)
                                .addComponent(GonderilecekSoyadTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67)
                                .addComponent(GonderilecekIBANTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67)
                                .addGroup(IslParaGönderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(GonderilecekMiktarTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(GonderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(50, Short.MAX_VALUE))
        );

        IslemlerPanelContainer.add(IslParaGönderPanel, "cardIslParaGönderPanel");

        IslVadeliBilgilendirmePanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        IslVadeliHesapBilgilendirmeLabel.setText("vadeli hesabınız bilgi");

        IslVadeliVadeliHesapGormeBtn.setText("Vadeli Hesaplarım");
        IslVadeliVadeliHesapGormeBtn.addActionListener(this::IslVadeliVadeliHesapGormeBtnActionPerformed);

        javax.swing.GroupLayout IslVadeliBilgilendirmePanelLayout = new javax.swing.GroupLayout(IslVadeliBilgilendirmePanel);
        IslVadeliBilgilendirmePanel.setLayout(IslVadeliBilgilendirmePanelLayout);
        IslVadeliBilgilendirmePanelLayout.setHorizontalGroup(
                IslVadeliBilgilendirmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(IslVadeliBilgilendirmePanelLayout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(IslVadeliHesapBilgilendirmeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 312, Short.MAX_VALUE)
                                .addComponent(IslVadeliVadeliHesapGormeBtn)
                                .addGap(23, 23, 23))
        );
        IslVadeliBilgilendirmePanelLayout.setVerticalGroup(
                IslVadeliBilgilendirmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(IslVadeliBilgilendirmePanelLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(IslVadeliBilgilendirmePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(IslVadeliHesapBilgilendirmeLabel)
                                        .addComponent(IslVadeliVadeliHesapGormeBtn))
                                .addContainerGap(50, Short.MAX_VALUE))
        );

        IslVadeliHesapAdlandirmaTextF.setText("jTextField1");

        IslVadeSecenekleriComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kısa (32 Gün) - %40 Faiz", "Orta (92 Gün) - %45 Faiz", "Uzun (181 Gün) - %48 Faiz", "Yıllık (365 Gün) - %50 Faiz" }));

        IslVadeliBilgilendirmeLabel.setText("jLabel11");

        IslVadeYatirilacakMiktarTextF.setText("jTextField1");

        IslVadeliKazancLabel.setText("jLabel12");

        IslVadeliHesapOnizle.setText("Önizle");
        IslVadeliHesapOnizle.addActionListener(this::IslVadeliHesapOnizleActionPerformed);

        IslVadeliHesapOlustur.setText("Vadeli Hesabı Oluştur");
        IslVadeliHesapOlustur.addActionListener(this::IslVadeliHesapOlusturActionPerformed);

        javax.swing.GroupLayout IslVadeliPanelLayout = new javax.swing.GroupLayout(IslVadeliPanel);
        IslVadeliPanel.setLayout(IslVadeliPanelLayout);
        IslVadeliPanelLayout.setHorizontalGroup(
                IslVadeliPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, IslVadeliPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(IslVadeliPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                        .addComponent(IslVadeliHesapAdlandirmaTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(IslVadeSecenekleriComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(IslVadeliBilgilendirmeLabel)
                                        .addComponent(IslVadeYatirilacakMiktarTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(IslVadeliKazancLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(IslVadeliPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(IslVadeliHesapOlustur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(IslVadeliHesapOnizle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(92, 92, 92))
                        .addGroup(IslVadeliPanelLayout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(IslVadeliBilgilendirmePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(43, Short.MAX_VALUE))
        );
        IslVadeliPanelLayout.setVerticalGroup(
                IslVadeliPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(IslVadeliPanelLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(IslVadeliBilgilendirmePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(IslVadeliPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(IslVadeliPanelLayout.createSequentialGroup()
                                                .addGap(145, 145, 145)
                                                .addComponent(IslVadeliHesapOnizle)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(IslVadeliHesapOlustur))
                                        .addGroup(IslVadeliPanelLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(IslVadeliHesapAdlandirmaTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(IslVadeSecenekleriComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(IslVadeliBilgilendirmeLabel)
                                                .addGap(18, 18, 18)
                                                .addComponent(IslVadeYatirilacakMiktarTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(IslVadeliKazancLabel)))
                                .addContainerGap(117, Short.MAX_VALUE))
        );

        IslemlerPanelContainer.add(IslVadeliPanel, "cardIslVadeliPanel");

        lbl10.setText("Dolar");

        lbl11.setText("Euro");

        lbl12.setText("Altın");

        IslDovizDolarAlısKur.setText("DolarAlışKur");

        IslDovizDolarSatısKur.setText("Dolar SatışKur");

        IslDovizEuroAlısKur.setText("EuroAlışKur");

        IslDovizEuroSatısKur.setText("EuroSatışKur");

        IslDovizAltinAlısKur.setText("AltınAlışKur");

        IslDovizAltinSatisKur.setText("AltınSatışKur");

        IslAlınacakDolarMiktariTextF.setText("jTextField1");

        IslSatilacakDolarMiktariTextF.setText("jTextField2");

        IslAlınacakEuroMiktariTextF.setText("jTextField3");

        IslSatilacakEuroMiktariTextF.setText("jTextField4");

        IslAlınacakAltınMiktariTextF.setText("jTextField5");

        IslSatılacakAlMiktariTextF.setText("jTextField6");

        IslDovizDolarIslemi.setText("jToggleButton1");
        IslDovizDolarIslemi.addActionListener(this::IslDovizDolarIslemiActionPerformed);

        IslDovizEuroIslemi.setText("jToggleButton2");
        IslDovizEuroIslemi.addActionListener(this::IslDovizEuroIslemiActionPerformed);

        IslDovizAltinIslemi.setText("jToggleButton3");
        IslDovizAltinIslemi.addActionListener(this::IslDovizAltinIslemiActionPerformed);

        DolarIslemleri.add(DolarAlRadioBtn);
        DolarAlRadioBtn.setText("Dolar Al");

        DolarIslemleri.add(DolarSatRadioBtn);
        DolarSatRadioBtn.setText("Dolar Sat");

        EuroIslemleri.add(EuroAlRadioBtn);
        EuroAlRadioBtn.setText("Euro Al");

        EuroIslemleri.add(EuroSatRadioBtn);
        EuroSatRadioBtn.setText("Euro Sat");
        EuroSatRadioBtn.addActionListener(this::EuroSatRadioBtnActionPerformed);

        AltinIslemleri.add(AltinAlRadioBtn);
        AltinAlRadioBtn.setText("Altın Al");

        AltinIslemleri.add(AltinSatRadioBtn);
        AltinSatRadioBtn.setText("Altın Sat");

        javax.swing.GroupLayout IslDovizPanelLayout = new javax.swing.GroupLayout(IslDovizPanel);
        IslDovizPanel.setLayout(IslDovizPanelLayout);
        IslDovizPanelLayout.setHorizontalGroup(
                IslDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(IslDovizPanelLayout.createSequentialGroup()
                                .addGroup(IslDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(IslDovizPanelLayout.createSequentialGroup()
                                                .addGap(82, 82, 82)
                                                .addGroup(IslDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(IslDovizDolarSatısKur)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, IslDovizPanelLayout.createSequentialGroup()
                                                                .addComponent(IslDovizDolarAlısKur)
                                                                .addGap(8, 8, 8))))
                                        .addGroup(IslDovizPanelLayout.createSequentialGroup()
                                                .addGap(122, 122, 122)
                                                .addComponent(lbl10)))
                                .addGroup(IslDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(IslDovizPanelLayout.createSequentialGroup()
                                                .addGap(130, 130, 130)
                                                .addGroup(IslDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(IslDovizEuroAlısKur)
                                                        .addComponent(IslDovizEuroSatısKur, javax.swing.GroupLayout.Alignment.TRAILING)))
                                        .addGroup(IslDovizPanelLayout.createSequentialGroup()
                                                .addGap(141, 141, 141)
                                                .addComponent(lbl11)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(IslDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, IslDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, IslDovizPanelLayout.createSequentialGroup()
                                                        .addComponent(IslDovizAltinAlısKur)
                                                        .addGap(112, 112, 112))
                                                .addGroup(IslDovizPanelLayout.createSequentialGroup()
                                                        .addComponent(IslDovizAltinSatisKur)
                                                        .addContainerGap()))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, IslDovizPanelLayout.createSequentialGroup()
                                                .addComponent(lbl12)
                                                .addGap(117, 117, 117))))
                        .addGroup(IslDovizPanelLayout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addGroup(IslDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(IslDovizPanelLayout.createSequentialGroup()
                                                .addGroup(IslDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(DolarAlRadioBtn)
                                                        .addComponent(DolarSatRadioBtn))
                                                .addGap(113, 113, 113)
                                                .addGroup(IslDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(EuroSatRadioBtn)
                                                        .addComponent(EuroAlRadioBtn)))
                                        .addGroup(IslDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(IslDovizPanelLayout.createSequentialGroup()
                                                        .addComponent(IslSatilacakDolarMiktariTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(IslSatilacakEuroMiktariTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(IslDovizPanelLayout.createSequentialGroup()
                                                        .addComponent(IslAlınacakDolarMiktariTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(103, 103, 103)
                                                        .addComponent(IslAlınacakEuroMiktariTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 200, Short.MAX_VALUE)
                                .addGroup(IslDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(IslAlınacakAltınMiktariTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(IslSatılacakAlMiktariTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(AltinAlRadioBtn)
                                        .addComponent(AltinSatRadioBtn))
                                .addGap(95, 95, 95))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, IslDovizPanelLayout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(IslDovizDolarIslemi)
                                .addGap(64, 64, 64)
                                .addComponent(IslDovizEuroIslemi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(IslDovizAltinIslemi)
                                .addGap(75, 75, 75))
        );
        IslDovizPanelLayout.setVerticalGroup(
                IslDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(IslDovizPanelLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(IslDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbl10)
                                        .addComponent(lbl11)
                                        .addComponent(lbl12))
                                .addGap(18, 18, 18)
                                .addGroup(IslDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(IslAlınacakDolarMiktariTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(IslAlınacakEuroMiktariTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(IslAlınacakAltınMiktariTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(IslDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(IslSatilacakDolarMiktariTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(IslSatilacakEuroMiktariTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(IslSatılacakAlMiktariTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14)
                                .addGroup(IslDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(DolarAlRadioBtn)
                                        .addComponent(EuroAlRadioBtn)
                                        .addComponent(AltinAlRadioBtn))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(IslDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(DolarSatRadioBtn)
                                        .addComponent(EuroSatRadioBtn)
                                        .addComponent(AltinSatRadioBtn))
                                .addGap(39, 39, 39)
                                .addGroup(IslDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(IslDovizDolarIslemi)
                                        .addComponent(IslDovizEuroIslemi)
                                        .addComponent(IslDovizAltinIslemi))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                                .addGroup(IslDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(IslDovizEuroAlısKur)
                                        .addComponent(IslDovizDolarAlısKur)
                                        .addComponent(IslDovizAltinAlısKur))
                                .addGap(18, 18, 18)
                                .addGroup(IslDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(IslDovizDolarSatısKur)
                                        .addComponent(IslDovizEuroSatısKur)
                                        .addComponent(IslDovizAltinSatisKur))
                                .addGap(43, 43, 43))
        );

        IslemlerPanelContainer.add(IslDovizPanel, "cardIslDovizPanel");

        IslParaGönderBtn.setText("Para Gönderme");
        IslParaGönderBtn.addActionListener(this::IslParaGönderBtnActionPerformed);

        IslVadeliBtn.setText("Vadeli Hesap İşlemleri");
        IslVadeliBtn.addActionListener(this::IslVadeliBtnActionPerformed);

        IslDovizBtn.setText("Döviz İşlemleri");
        IslDovizBtn.addActionListener(this::IslDovizBtnActionPerformed);

        IslBilgiPanelBtn.setText("BilgiPaneli");
        IslBilgiPanelBtn.addActionListener(this::IslBilgiPanelBtnActionPerformed);

        javax.swing.GroupLayout IslemlerPanelLayout = new javax.swing.GroupLayout(IslemlerPanel);
        IslemlerPanel.setLayout(IslemlerPanelLayout);
        IslemlerPanelLayout.setHorizontalGroup(
                IslemlerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(IslemlerPanelLayout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addGroup(IslemlerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(IslDovizBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(IslParaGönderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(IslVadeliBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(IslBilgiPanelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(58, 58, 58)
                                .addComponent(IslemlerPanelContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        IslemlerPanelLayout.setVerticalGroup(
                IslemlerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(IslemlerPanelLayout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(IslBilgiPanelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(IslParaGönderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(IslVadeliBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(IslDovizBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(79, Short.MAX_VALUE))
                        .addGroup(IslemlerPanelLayout.createSequentialGroup()
                                .addComponent(IslemlerPanelContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        PanelContainer.add(IslemlerPanel, "cardIslemlerPanel");

        HesaplarPanelContainer.setLayout(new java.awt.CardLayout());

        HspVadesizBakiyeLbl.setText("Bakiye");

        HspVadesizIBANLbl.setText("Iban");

        HspVadesizParaTrnsfrBtn.setText("Para Transferi Yap");
        HspVadesizParaTrnsfrBtn.addActionListener(this::HspVadesizParaTrnsfrBtnActionPerformed);

        HspVadesizFaturaOdeBtn.setText("Fatura Öde");
        HspVadesizFaturaOdeBtn.addActionListener(this::HspVadesizFaturaOdeBtnActionPerformed);

        javax.swing.GroupLayout HspVadesizPanelLayout = new javax.swing.GroupLayout(HspVadesizPanel);
        HspVadesizPanel.setLayout(HspVadesizPanelLayout);
        HspVadesizPanelLayout.setHorizontalGroup(
                HspVadesizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(HspVadesizPanelLayout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(HspVadesizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(HspVadesizIBANLbl)
                                        .addComponent(HspVadesizBakiyeLbl))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HspVadesizPanelLayout.createSequentialGroup()
                                .addGap(0, 370, Short.MAX_VALUE)
                                .addGroup(HspVadesizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(HspVadesizParaTrnsfrBtn)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HspVadesizPanelLayout.createSequentialGroup()
                                                .addComponent(HspVadesizFaturaOdeBtn)
                                                .addGap(18, 18, 18)))
                                .addGap(238, 238, 238))
        );
        HspVadesizPanelLayout.setVerticalGroup(
                HspVadesizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(HspVadesizPanelLayout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(HspVadesizBakiyeLbl)
                                .addGap(1, 1, 1)
                                .addComponent(HspVadesizParaTrnsfrBtn)
                                .addGap(23, 23, 23)
                                .addComponent(HspVadesizIBANLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(HspVadesizFaturaOdeBtn)
                                .addGap(0, 239, Short.MAX_VALUE))
        );

        HesaplarPanelContainer.add(HspVadesizPanel, "cardHspVadesizPanel");

        HspVadeliPanel.setLayout(new java.awt.CardLayout());

        lbl9.setText("vadeli hesabın yok");

        HspVadeliAcBtn.setText("vadeli hesap aç");
        HspVadeliAcBtn.addActionListener(this::HspVadeliAcBtnActionPerformed);

        javax.swing.GroupLayout HspVadeliYokPanelLayout = new javax.swing.GroupLayout(HspVadeliYokPanel);
        HspVadeliYokPanel.setLayout(HspVadeliYokPanelLayout);
        HspVadeliYokPanelLayout.setHorizontalGroup(
                HspVadeliYokPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(HspVadeliYokPanelLayout.createSequentialGroup()
                                .addGroup(HspVadeliYokPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(HspVadeliYokPanelLayout.createSequentialGroup()
                                                .addGap(313, 313, 313)
                                                .addComponent(lbl9))
                                        .addGroup(HspVadeliYokPanelLayout.createSequentialGroup()
                                                .addGap(304, 304, 304)
                                                .addComponent(HspVadeliAcBtn)))
                                .addContainerGap(319, Short.MAX_VALUE))
        );
        HspVadeliYokPanelLayout.setVerticalGroup(
                HspVadeliYokPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(HspVadeliYokPanelLayout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(lbl9)
                                .addGap(64, 64, 64)
                                .addComponent(HspVadeliAcBtn)
                                .addContainerGap(233, Short.MAX_VALUE))
        );

        HspVadeliPanel.add(HspVadeliYokPanel, "cardHspVadeliYokPanel");

        HspVadeliListComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        HspVadeliTürüLbl.setText("Türü");

        HspVadeliYatirilanTutarLbl.setText("Yatırılan Tutar");

        HspVadeliKalanGunLbl.setText("Kaç gün kaldı");

        HspVadeliKalanGetirisiLbl.setText("Getirisi");

        HspVadeliYeniHesapBtn.setText("Başka Bir Vadeli Hesap Oluştur");
        HspVadeliYeniHesapBtn.addActionListener(this::HspVadeliYeniHesapBtnActionPerformed);

        javax.swing.GroupLayout HspVadeliVarPanelLayout = new javax.swing.GroupLayout(HspVadeliVarPanel);
        HspVadeliVarPanel.setLayout(HspVadeliVarPanelLayout);
        HspVadeliVarPanelLayout.setHorizontalGroup(
                HspVadeliVarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(HspVadeliVarPanelLayout.createSequentialGroup()
                                .addGroup(HspVadeliVarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(HspVadeliVarPanelLayout.createSequentialGroup()
                                                .addGap(169, 169, 169)
                                                .addComponent(HspVadeliListComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(HspVadeliVarPanelLayout.createSequentialGroup()
                                                .addGap(81, 81, 81)
                                                .addGroup(HspVadeliVarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(HspVadeliKalanGunLbl)
                                                        .addComponent(HspVadeliTürüLbl)
                                                        .addComponent(HspVadeliKalanGetirisiLbl)
                                                        .addComponent(HspVadeliYatirilanTutarLbl))))
                                .addContainerGap(274, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HspVadeliVarPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(HspVadeliYeniHesapBtn)
                                .addGap(20, 20, 20))
        );
        HspVadeliVarPanelLayout.setVerticalGroup(
                HspVadeliVarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(HspVadeliVarPanelLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(HspVadeliListComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(HspVadeliTürüLbl)
                                .addGap(42, 42, 42)
                                .addComponent(HspVadeliYatirilanTutarLbl)
                                .addGap(44, 44, 44)
                                .addComponent(HspVadeliKalanGunLbl)
                                .addGap(34, 34, 34)
                                .addComponent(HspVadeliKalanGetirisiLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                                .addComponent(HspVadeliYeniHesapBtn)
                                .addGap(28, 28, 28))
        );

        HspVadeliPanel.add(HspVadeliVarPanel, "cardHspVadeliVarPanel");

        HesaplarPanelContainer.add(HspVadeliPanel, "cardHspVadeliPanel");

        HspDovizDolarBakiyeLabel.setText("Dolar Bakiyesi");

        HspDovizEuroBakiyeLabel.setText("Euro Bakiyesi");

        HspDovizAltınBakiyeLabel.setText("Altın Bakiyesi");

        HspDovizDolarTLLabel.setText("Dolar-TL");

        HspDovizEuroTLLabel.setText("Euro-TL");

        HspDovizAltınTLLabel.setText("Altın-TL");

        HspDovizIslemleriBtn.setText("Döviz İşlemleri");
        HspDovizIslemleriBtn.addActionListener(this::HspDovizIslemleriBtnActionPerformed);

        javax.swing.GroupLayout HspDovizPanelLayout = new javax.swing.GroupLayout(HspDovizPanel);
        HspDovizPanel.setLayout(HspDovizPanelLayout);
        HspDovizPanelLayout.setHorizontalGroup(
                HspDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(HspDovizPanelLayout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addGroup(HspDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(HspDovizDolarBakiyeLabel)
                                        .addComponent(HspDovizEuroBakiyeLabel)
                                        .addComponent(HspDovizAltınBakiyeLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 331, Short.MAX_VALUE)
                                .addGroup(HspDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(HspDovizAltınTLLabel)
                                        .addComponent(HspDovizEuroTLLabel)
                                        .addComponent(HspDovizDolarTLLabel))
                                .addGap(215, 215, 215))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HspDovizPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(HspDovizIslemleriBtn)
                                .addGap(78, 78, 78))
        );
        HspDovizPanelLayout.setVerticalGroup(
                HspDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(HspDovizPanelLayout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addGroup(HspDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(HspDovizDolarBakiyeLabel)
                                        .addComponent(HspDovizDolarTLLabel))
                                .addGap(77, 77, 77)
                                .addGroup(HspDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(HspDovizEuroBakiyeLabel)
                                        .addComponent(HspDovizEuroTLLabel))
                                .addGap(60, 60, 60)
                                .addGroup(HspDovizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(HspDovizAltınBakiyeLabel)
                                        .addComponent(HspDovizAltınTLLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                                .addComponent(HspDovizIslemleriBtn)
                                .addGap(43, 43, 43))
        );

        HesaplarPanelContainer.add(HspDovizPanel, "cardHspDovizPanel");

        HspVadesizBtn.setText("Vadesiz");
        HspVadesizBtn.addActionListener(this::HspVadesizBtnActionPerformed);

        HspVadeliBtn.setText("Vadeli");
        HspVadeliBtn.addActionListener(this::HspVadeliBtnActionPerformed);

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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(HesaplarPanelContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 737, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(32, Short.MAX_VALUE))
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
                                                .addGap(17, 17, 17)
                                                .addComponent(HesaplarPanelContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(40, Short.MAX_VALUE))
        );

        PanelContainer.add(HesaplarPanel, "cardHesaplarPanel");

        lbl6.setText("Banka Kartı");

        javax.swing.GroupLayout KrtBankaKartiPanelLayout = new javax.swing.GroupLayout(KrtBankaKartiPanel);
        KrtBankaKartiPanel.setLayout(KrtBankaKartiPanelLayout);
        KrtBankaKartiPanelLayout.setHorizontalGroup(
                KrtBankaKartiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(KrtBankaKartiPanelLayout.createSequentialGroup()
                                .addComponent(lbl6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 589, Short.MAX_VALUE))
        );
        KrtBankaKartiPanelLayout.setVerticalGroup(
                KrtBankaKartiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(KrtBankaKartiPanelLayout.createSequentialGroup()
                                .addComponent(lbl6)
                                .addGap(0, 186, Short.MAX_VALUE))
        );

        lbl7.setText("Kredi Kartı");

        javax.swing.GroupLayout KrtKrediKartiPanelLayout = new javax.swing.GroupLayout(KrtKrediKartiPanel);
        KrtKrediKartiPanel.setLayout(KrtKrediKartiPanelLayout);
        KrtKrediKartiPanelLayout.setHorizontalGroup(
                KrtKrediKartiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(KrtKrediKartiPanelLayout.createSequentialGroup()
                                .addComponent(lbl7)
                                .addGap(0, 627, Short.MAX_VALUE))
        );
        KrtKrediKartiPanelLayout.setVerticalGroup(
                KrtKrediKartiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(KrtKrediKartiPanelLayout.createSequentialGroup()
                                .addComponent(lbl7)
                                .addGap(0, 198, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout KartlarPanelLayout = new javax.swing.GroupLayout(KartlarPanel);
        KartlarPanel.setLayout(KartlarPanelLayout);
        KartlarPanelLayout.setHorizontalGroup(
                KartlarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(KartlarPanelLayout.createSequentialGroup()
                                .addGap(158, 158, 158)
                                .addGroup(KartlarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(KrtBankaKartiPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(KrtKrediKartiPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(170, Short.MAX_VALUE))
        );
        KartlarPanelLayout.setVerticalGroup(
                KartlarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(KartlarPanelLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(KrtBankaKartiPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(KrtKrediKartiPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(37, Short.MAX_VALUE))
        );

        PanelContainer.add(KartlarPanel, "cardKartlarPanel");

        FtrAboneliklerimBtn.setText("Aboneliklerim");
        FtrAboneliklerimBtn.addActionListener(this::FtrAboneliklerimBtnActionPerformed);

        FtrFaturalarımBtn.setText("Faturalarım");
        FtrFaturalarımBtn.addActionListener(this::FtrFaturalarımBtnActionPerformed);

        FaturalarPanelContainer.setLayout(new java.awt.CardLayout());

        jLabel31.setText("abn");

        javax.swing.GroupLayout FtrAboneliklerimPanelLayout = new javax.swing.GroupLayout(FtrAboneliklerimPanel);
        FtrAboneliklerimPanel.setLayout(FtrAboneliklerimPanelLayout);
        FtrAboneliklerimPanelLayout.setHorizontalGroup(
                FtrAboneliklerimPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(FtrAboneliklerimPanelLayout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addComponent(jLabel31)
                                .addContainerGap(557, Short.MAX_VALUE))
        );
        FtrAboneliklerimPanelLayout.setVerticalGroup(
                FtrAboneliklerimPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(FtrAboneliklerimPanelLayout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(jLabel31)
                                .addContainerGap(319, Short.MAX_VALUE))
        );

        FaturalarPanelContainer.add(FtrAboneliklerimPanel, "cardFtrAboneliklerimPanel");

        jLabel32.setText("ftr");

        javax.swing.GroupLayout FtrFaturalarımPanelLayout = new javax.swing.GroupLayout(FtrFaturalarımPanel);
        FtrFaturalarımPanel.setLayout(FtrFaturalarımPanelLayout);
        FtrFaturalarımPanelLayout.setHorizontalGroup(
                FtrFaturalarımPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(FtrFaturalarımPanelLayout.createSequentialGroup()
                                .addGap(229, 229, 229)
                                .addComponent(jLabel32)
                                .addContainerGap(434, Short.MAX_VALUE))
        );
        FtrFaturalarımPanelLayout.setVerticalGroup(
                FtrFaturalarımPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(FtrFaturalarımPanelLayout.createSequentialGroup()
                                .addGap(147, 147, 147)
                                .addComponent(jLabel32)
                                .addContainerGap(244, Short.MAX_VALUE))
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                                .addComponent(FaturalarPanelContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jLabel20.setText("jLabel20");

        jLabel21.setText("jLabel21");

        jLabel22.setText("jLabel22");

        jLabel23.setText("jLabel23");

        javax.swing.GroupLayout VarliklarPanelLayout = new javax.swing.GroupLayout(VarliklarPanel);
        VarliklarPanel.setLayout(VarliklarPanelLayout);
        VarliklarPanelLayout.setHorizontalGroup(
                VarliklarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(VarliklarPanelLayout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(jLabel20)
                                .addGap(196, 196, 196)
                                .addComponent(jLabel21)
                                .addGap(184, 184, 184)
                                .addComponent(jLabel22)
                                .addGap(165, 165, 165)
                                .addComponent(jLabel23)
                                .addContainerGap(199, Short.MAX_VALUE))
        );
        VarliklarPanelLayout.setVerticalGroup(
                VarliklarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(VarliklarPanelLayout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addGroup(VarliklarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel20)
                                        .addComponent(jLabel21)
                                        .addComponent(jLabel22)
                                        .addComponent(jLabel23))
                                .addContainerGap(387, Short.MAX_VALUE))
        );

        PanelContainer.add(VarliklarPanel, "cardVarliklarPanel");

        jLabel24.setText("jLabel24");

        jLabel25.setText("jLabel25");

        jLabel26.setText("jLabel26");

        jLabel27.setText("jLabel27");

        javax.swing.GroupLayout GuncelKurPanelLayout = new javax.swing.GroupLayout(GuncelKurPanel);
        GuncelKurPanel.setLayout(GuncelKurPanelLayout);
        GuncelKurPanelLayout.setHorizontalGroup(
                GuncelKurPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(GuncelKurPanelLayout.createSequentialGroup()
                                .addGap(157, 157, 157)
                                .addComponent(jLabel24)
                                .addGap(225, 225, 225)
                                .addComponent(jLabel25)
                                .addGap(170, 170, 170)
                                .addComponent(jLabel26)
                                .addGap(129, 129, 129)
                                .addComponent(jLabel27)
                                .addContainerGap(157, Short.MAX_VALUE))
        );
        GuncelKurPanelLayout.setVerticalGroup(
                GuncelKurPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(GuncelKurPanelLayout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addGroup(GuncelKurPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel24)
                                        .addComponent(jLabel25)
                                        .addComponent(jLabel26)
                                        .addComponent(jLabel27))
                                .addContainerGap(365, Short.MAX_VALUE))
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
        // 1. Sayfayı Aç
        mainSayfaDegistir("cardHesaplarPanel");
        panelAdiLabel.setText("HESAPLARIM");

        // 2. --- EKSİK OLAN KISIM ---
        hesaplariGuncelle();          // Döviz ve Vadesiz bakiyeleri çek
        vadeliHesapSayfasiniYonet();  // Vadeli hesap var mı kontrol et
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

    private void IslBilgiPanelBtnActionPerformed(java.awt.event.ActionEvent evt) {
        islemlerSayfaDegistir("cardIslBilgiPanel");
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

    private void HspVadesizBtnActionPerformed(java.awt.event.ActionEvent evt) {
        hesaplarSayfaDegistir("cardHspVadesizPanel");
    }

    private void HspVadeliBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // 1. Sekmeyi Aç
        hesaplarSayfaDegistir("cardHspVadeliPanel");

        // 2. --- EKSİK OLAN KISIM ---
        vadeliHesapSayfasiniYonet(); // Listeyi anında tazele
    }

    private void HspDövizBtnActionPerformed(java.awt.event.ActionEvent evt) {
        hesaplarSayfaDegistir("cardHspDovizPanel");
    }

    private void FtrAboneliklerimBtnActionPerformed(java.awt.event.ActionEvent evt) {
        faturalarSayfaDegistir("cardFtrAboneliklerimPanel");
    }

    private void FtrFaturalarımBtnActionPerformed(java.awt.event.ActionEvent evt) {
        faturalarSayfaDegistir("cardFtrFaturalarımPanel");
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
        // TODO add your handling code here:
    }

    private void HspVadesizFaturaOdeBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void HspDovizIslemleriBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void EuroSatRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void GonderBtnActionPerformed(java.awt.event.ActionEvent evt) {
        String aliciIban = GonderilecekIBANTextF.getText().trim();
        String miktarStr = GonderilecekMiktarTextF.getText().trim();

        if(aliciIban.isEmpty() || miktarStr.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Lütfen IBAN ve Tutar giriniz.");
            return;
        }

        try {
            double miktar = Double.parseDouble(miktarStr);
            // DataBaseManager'a eklediğimiz metodu çağırıyoruz
            String sonuc = Managers.DataBaseManager.paraTransferiYap(aktifKullanici.getUserId(), aliciIban, miktar);

            if(sonuc.equals("BASARILI")) {
                javax.swing.JOptionPane.showMessageDialog(this, "Transfer Başarıyla Gerçekleşti!");
                hesaplariGuncelle(); // Bakiyeyi yenile
                anaSayfaGuncelle();
                GonderilecekMiktarTextF.setText("");
                GonderilecekIBANTextF.setText("");
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, sonuc); // Hata mesajı
            }
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Lütfen geçerli bir tutar giriniz.");
        }
    }

    private void IslVadeliHesapOnizleActionPerformed(java.awt.event.ActionEvent evt) {
        String miktarStr = IslVadeYatirilacakMiktarTextF.getText().trim();
        String secilenVade = (String) IslVadeSecenekleriComboBox.getSelectedItem(); // "Kısa (32 Gün) - %40"

        if (miktarStr.isEmpty()) return;

        try {
            double miktar = Double.parseDouble(miktarStr);

            // Basit faiz hesaplama simülasyonu
            int gun = 32;
            double oran = 40.0;

            if (secilenVade.contains("92")) { gun = 92; oran = 45.0; }
            else if (secilenVade.contains("181")) { gun = 181; oran = 48.0; }
            else if (secilenVade.contains("365")) { gun = 365; oran = 50.0; }

            // Formül: (AnaPara * Faiz * Gün) / 36500
            double brurKazanc = (miktar * oran * gun) / 36500.0;
            double netKazanc = brurKazanc * 0.95; // %5 Stopaj düşelim

            IslVadeliKazancLabel.setText(String.format("Tahmini Net Kazanç: %.2f TL", netKazanc));
            IslVadeliBilgilendirmeLabel.setText(gun + " Gün sonunda toplam: " + String.format("%.2f", (miktar + netKazanc)) + " TL");

        } catch (Exception e) {
            IslVadeliKazancLabel.setText("Hesaplama Hatası");
        }
    }

    private void IslVadeliHesapOlusturActionPerformed(java.awt.event.ActionEvent evt) {
        // 1. Verileri Al
        String hesapAdi = IslVadeliHesapAdlandirmaTextF.getText().trim();
        String miktarStr = IslVadeYatirilacakMiktarTextF.getText().trim();
        String secilenVade = (String) IslVadeSecenekleriComboBox.getSelectedItem();

        // 2. Basit Kontroller
        if (hesapAdi.isEmpty() || miktarStr.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Lütfen hesap adı ve tutar giriniz.");
            return;
        }

        // Vade Gününü Ayıkla (String içinden)
        int vadeGun = 32; // Varsayılan
        if (secilenVade.contains("92")) vadeGun = 92;
        else if (secilenVade.contains("181")) vadeGun = 181;
        else if (secilenVade.contains("365")) vadeGun = 365;

        try {
            double miktar = Double.parseDouble(miktarStr);

            // 3. İŞLEMİ YAP (Yeni yazdığımız Manager metodunu çağırıyoruz)
            String sonuc = Managers.DataBaseManager.createVadeliAccountWithDeduction(aktifKullanici.getUserId(), hesapAdi, miktar, vadeGun);

            if (sonuc.equals("BASARILI")) {
                javax.swing.JOptionPane.showMessageDialog(this, "Vadeli Hesap Başarıyla Açıldı!\n" + miktar + " TL vadesiz hesabınızdan çekildi.");

                // 4. EKRANLARI GÜNCELLE
                anaSayfaGuncelle(); // Vadesiz bakiye düşsün
                hesaplariGuncelle(); // Hesap listeleri yenilensin
                vadeliHesapSayfasiniYonet(); // Vadeli listesi dolsun

                // 5. YÖNLENDİRME (Kritik Kısım)
                // Önce ana kartı "HESAPLAR" yap
                mainSayfaDegistir("cardHesaplarPanel");
                panelAdiLabel.setText("HESAPLARIM");

                // Sonra hesaplar içindeki alt kartı "VADELİ" yap
                hesaplarSayfaDegistir("cardHspVadeliPanel");

                // Formu temizle
                IslVadeliHesapAdlandirmaTextF.setText("");
                IslVadeYatirilacakMiktarTextF.setText("");

            } else {
                // Hata mesajı (Yetersiz bakiye vb.)
                javax.swing.JOptionPane.showMessageDialog(this, sonuc);
            }

        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Lütfen geçerli bir tutar giriniz.");
        }
    }

    private void IslVadeliVadeliHesapGormeBtnActionPerformed(java.awt.event.ActionEvent evt) {
        hesaplarSayfaDegistir("cardHspVadeliPanel");
        vadeliHesapSayfasiniYonet();
    }

    private void IslDovizDolarIslemiActionPerformed(java.awt.event.ActionEvent evt) {
        dovizIslemiYap("DOLAR", IslAlınacakDolarMiktariTextF, IslSatilacakDolarMiktariTextF, DolarAlRadioBtn, DolarSatRadioBtn);
    }

    private void IslDovizEuroIslemiActionPerformed(java.awt.event.ActionEvent evt) {
        dovizIslemiYap("EURO", IslAlınacakEuroMiktariTextF, IslSatilacakEuroMiktariTextF, EuroAlRadioBtn, EuroSatRadioBtn);
    }

    private void IslDovizAltinIslemiActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
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
        java.awt.EventQueue.invokeLater(() -> new UI.BireyselKullaniciUI(null).setVisible(true));
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
        double altinKur = Managers.CurrencyManager.getBuyRate("GOLD");
        double altinTlKarsiligi = altinMiktar * altinKur;

        HspDovizAltınTLLabel.setText(String.format("≈ %,.2f TL", altinTlKarsiligi));
    }

    // --- VADELİ HESAP EKRANI YÖNETİMİ (Mantık Burada) ---
    private void vadeliHesapSayfasiniYonet() {
        if (aktifKullanici == null) return;

        // 1. Veritabanından İsim Listesini Çek (Senin yazdığın metot)
        java.util.ArrayList<String> hesapListesi = Managers.DataBaseManager.getVadeliAccountNames(aktifKullanici.getUserId());

        // 2. CardLayout'u Hazırla
        java.awt.CardLayout layout = (java.awt.CardLayout) HspVadeliPanel.getLayout();

        if (hesapListesi.isEmpty()) {
            // --- Durum A: HESAP YOK (Reklam Göster) ---
            layout.show(HspVadeliPanel, "cardHspVadeliYokPanel");

        } else {
            // --- Durum B: HESAP VAR (Listeyi Göster) ---
            layout.show(HspVadeliPanel, "cardHspVadeliVarPanel");

            // ComboBox'ı Temizle ve Doldur
            HspVadeliListComboBox.removeAllItems();
            for (String hesapAdi : hesapListesi) {
                HspVadeliListComboBox.addItem(hesapAdi);
            }

            // İlk hesabı seçili yapınca detayları da doldurmak gerekecek
            // Şimdilik sadece listeyi dolduruyoruz.
        }
    }


    // =========================================================================
    // 5. YENİ İŞLEM MANTIKLARI (LOGIC) - BURAYI KOPYALA
    // =========================================================================

    // --- A. DÖVİZ KURLARINI EKRANA BASMA ---
    private void dovizKurlariniEkranaYaz() {
        // Dolar
        IslDovizDolarAlısKur.setText(String.valueOf(Managers.CurrencyManager.USD_BUY));
        IslDovizDolarSatısKur.setText(String.valueOf(Managers.CurrencyManager.USD_SELL));

        // Euro
        IslDovizEuroAlısKur.setText(String.valueOf(Managers.CurrencyManager.EUR_BUY));
        IslDovizEuroSatısKur.setText(String.valueOf(Managers.CurrencyManager.EUR_SELL));

        // Altın
        IslDovizAltinAlısKur.setText(String.valueOf(Managers.CurrencyManager.GOLD_BUY));
        IslDovizAltinSatisKur.setText(String.valueOf(Managers.CurrencyManager.GOLD_SELL));
    }

    // --- E. DÖVİZ İŞLEMLERİ (ORTAK METOT) ---
    private void dovizIslemiYap(String tur, javax.swing.JTextField alText, javax.swing.JTextField satText, javax.swing.JRadioButton rAl, javax.swing.JRadioButton rSat) {
        String accountType = "";
        if (tur.equals("DOLAR")) accountType = "USD";
        else if (tur.equals("EURO")) accountType = "EUR";
        else if (tur.equals("ALTIN")) accountType = "GOLD"; // veya ALTIN veritabanına göre

        try {
            // ALIŞ İŞLEMİ
            if (rAl.isSelected()) {
                String tutarStr = alText.getText().trim();
                if(tutarStr.isEmpty()) return;
                double tutarTL = Double.parseDouble(tutarStr);

                // Burada Model paketindeki ForeignCurrencyAccount.buyCurrency mantığını çağıracağız.
                // Ancak elimizde o account nesnesi yok.
                // Basit yol: DataBaseManager'da bir 'dovizAl(userId, type, tlAmount)' metodu olmalı.
                // Yoksa sadece simülasyon mesajı verelim:

                double kur = Managers.CurrencyManager.getSellRate(accountType);
                double alinanDoviz = tutarTL / kur;

                javax.swing.JOptionPane.showMessageDialog(this,
                        tutarTL + " TL karşılığında " + String.format("%.2f", alinanDoviz) + " " + tur + " alındı.\n(Hesap bakiyesi güncellenmedi - Manager metodu gerekli)");
            }
            // SATIŞ İŞLEMİ
            else if (rSat.isSelected()) {
                String tutarStr = satText.getText().trim();
                if(tutarStr.isEmpty()) return;
                double miktarDoviz = Double.parseDouble(tutarStr);

                double kur = Managers.CurrencyManager.getBuyRate(accountType);
                double kazanilanTL = miktarDoviz * kur;

                javax.swing.JOptionPane.showMessageDialog(this,
                        miktarDoviz + " " + tur + " satıldı. Hesaba " + String.format("%.2f", kazanilanTL) + " TL geçti.\n(Hesap bakiyesi güncellenmedi - Manager metodu gerekli)");
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Lütfen Alış veya Satış seçeneğini işaretleyin.");
            }

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Geçersiz Tutar.");
        }
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
    private javax.swing.JRadioButton DolarAlRadioBtn;
    private javax.swing.ButtonGroup DolarIslemleri;
    private javax.swing.JRadioButton DolarSatRadioBtn;
    private javax.swing.JRadioButton EuroAlRadioBtn;
    private javax.swing.ButtonGroup EuroIslemleri;
    private javax.swing.JRadioButton EuroSatRadioBtn;
    private javax.swing.JButton FaturalarBtn;
    private javax.swing.JPanel FaturalarPanel;
    private javax.swing.JPanel FaturalarPanelContainer;
    private javax.swing.JButton FtrAboneliklerimBtn;
    private javax.swing.JPanel FtrAboneliklerimPanel;
    private javax.swing.JButton FtrFaturalarımBtn;
    private javax.swing.JPanel FtrFaturalarımPanel;
    private javax.swing.JButton GonderBtn;
    private javax.swing.JTextField GonderilecekAdTextF;
    private javax.swing.JTextField GonderilecekIBANTextF;
    private javax.swing.JTextField GonderilecekMiktarTextF;
    private javax.swing.JTextField GonderilecekSoyadTextF;
    private javax.swing.JButton GuncelKurBtn;
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
    private javax.swing.JPanel IslBilgiPanel;
    private javax.swing.JButton IslBilgiPanelBtn;
    private javax.swing.JLabel IslDovizAltinAlısKur;
    private javax.swing.JToggleButton IslDovizAltinIslemi;
    private javax.swing.JLabel IslDovizAltinSatisKur;
    private javax.swing.JButton IslDovizBtn;
    private javax.swing.JLabel IslDovizDolarAlısKur;
    private javax.swing.JToggleButton IslDovizDolarIslemi;
    private javax.swing.JLabel IslDovizDolarSatısKur;
    private javax.swing.JLabel IslDovizEuroAlısKur;
    private javax.swing.JToggleButton IslDovizEuroIslemi;
    private javax.swing.JLabel IslDovizEuroSatısKur;
    private javax.swing.JPanel IslDovizPanel;
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
    private javax.swing.JPanel KrtBankaKartiPanel;
    private javax.swing.JPanel KrtKrediKartiPanel;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JLabel MusteriNoLabel;
    private javax.swing.JPanel PanelContainer;
    private javax.swing.JPanel UstPanel;
    private javax.swing.JButton VarliklarBtn;
    private javax.swing.JPanel VarliklarPanel;
    private javax.swing.JPanel YonlendirmePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
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

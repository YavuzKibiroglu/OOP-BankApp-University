import Managers.DataBaseManager;
import java.time.LocalDate;

void main() {
    System.out.println("Database Path: " + new java.io.File("Bank.db").getAbsolutePath());
    DataBaseManager.start();
    DataBaseManager.addIndividualUser("77889911223","Akif","Akçay","112233",LocalDate.of(2005,12,15),"Ankara","666666666");
}

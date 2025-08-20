package week3.day2;

public interface  DatabaseConnection {

  abstract void connect();
  abstract void disconnect();
  abstract void executeUpdate();
 
}

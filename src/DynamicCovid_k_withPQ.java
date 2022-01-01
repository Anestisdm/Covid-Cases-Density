import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DynamicCovid_k_withPQ {
    public static void main (String[] args) {
        BufferedReader reader = null;
        File f = new File(args[0]);
        ImageIcon icon1 = new ImageIcon("src/images/covid-19.png");
        Image image1 = icon1.getImage().getScaledInstance(40, 40, 0);
        ImageIcon icon2 = new ImageIcon("src/images/warning.png");
        Image image2 = icon2.getImage().getScaledInstance(40, 40, 0);
        try {
            reader = new BufferedReader(new FileReader(f));
            String line;
            line = reader.readLine();
            int c = 0;
            while (line != null) {
                c++;
                line = reader.readLine();
            }
            if (c >= 1) {
                String input = (String) JOptionPane.showInputDialog(null, "Enter the number of the cities:", "Covid Cases Density", JOptionPane.QUESTION_MESSAGE, new ImageIcon(image1), null, null);
                if (input != null) {
                    int k = Integer.parseInt(input);
                    PQ item = new PQ(k);
                    if (k <= c) {
                        reader = new BufferedReader(new FileReader(f));
                        line = reader.readLine();
                        while (line != null) {
                            StringTokenizer st = new StringTokenizer(line, " ");
                            while (st.hasMoreTokens()) {
                                int Id = Integer.parseInt(st.nextToken());
                                if (Id < 1 || Id > 999) {
                                    throw new IncorrectInputException("The Id " + Id + " is out of bounds");
                                }
                                String Name = st.nextToken();
                                if (Name.length() > 50) {
                                    throw new IncorrectInputException("The Name of the City " + Name + " is out of bounds");
                                }
                                int Population = Integer.parseInt(st.nextToken());
                                if (Population < 0 || Population >= 10000000) {
                                    throw new IncorrectInputException("The Population of " + Name + " is out of bounds");
                                }
                                int CovidCases = Integer.parseInt(st.nextToken());
                                if (CovidCases > Population) {
                                    throw new IncorrectInputException("Covid cases of " + Name + " is greater than the population");
                                }
                                City town = new City(Id, Name, Population, CovidCases, "PQ");
                                if (item.size() < k) {
                                    item.insert(town);
                                } else {
                                    if (town.compareTo(item.min()) > 0) {
                                        item.remove(item.min().getID());
                                        item.insert(town);
                                    }
                                }
                            }
                            line = reader.readLine();
                        }
                        String outputstr = "";
                        System.out.println("The top " + k + " cities are:");
                        for (int i = 1; i <= k; i++) {
                            String aux = item.getMax().getName();
                            System.out.println(aux);
                            outputstr += aux + "\n";
                        }
                        JOptionPane.showMessageDialog(null, outputstr, "The top " + k + " cities", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(image1));
                    } else {
                        throw new IncorrectInputException("Wrong input of number of the cities!");
                    }
                }
            }
            else {
                throw new NullPointerException();
            }

        } catch (FileNotFoundException e) {
            System.out.println("The file was not found");
            JOptionPane.showMessageDialog(null,"The file was not found","Error",JOptionPane.WARNING_MESSAGE,new ImageIcon (image2));
        } catch (IOException e) {
            System.out.println("Error reading file " + f.getName());
            JOptionPane.showMessageDialog(null,"Error reading file " + f.getName(),"Error",JOptionPane.WARNING_MESSAGE,new ImageIcon (image2));
        } catch (NullPointerException e) {
            System.out.println("The file " + f.getName() + " is empty!");
            JOptionPane.showMessageDialog(null,"The file " + f.getName() + " is empty!","Error",JOptionPane.WARNING_MESSAGE,new ImageIcon (image2));
        } catch (IncorrectInputException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.WARNING_MESSAGE,new ImageIcon (image2));
        } catch (InputMismatchException e) {
            System.out.println("Wrong type of input!");
            JOptionPane.showMessageDialog(null,"Wrong type of input!","Error",JOptionPane.WARNING_MESSAGE,new ImageIcon (image2));
        } catch (NumberFormatException e){
            System.out.println("Wrong input format!");
            JOptionPane.showMessageDialog(null,"Wrong input format!","Error",JOptionPane.WARNING_MESSAGE,new ImageIcon (image2));
        }
    }
}

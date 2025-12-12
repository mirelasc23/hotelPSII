package utilities;


//import javax.swing.JComponent;
import java.awt.Component;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Utilities {
    private static final EntityManagerFactory FACTORY = 
        Persistence.createEntityManagerFactory("PU");
    
    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }
    
    // Opcional: Para fechar a Factory ao desligar a aplicação
    public static void closeFactory() {
        if (FACTORY != null && FACTORY.isOpen()) {
            FACTORY.close();
        }
    }
    
    public static final String CHAVE_FUNCAO =  "ativaDesativaBusca()";
    
    public static void ativaDesativaBotoes(JPanel painel, boolean ativa){
        Component[] vetComponentes = painel.getComponents();
        
        for (Component componente : vetComponentes) {
            if (componente instanceof JButton) {
                if ("1".equals(((JButton)componente).getActionCommand())) {
                    componente.setEnabled(ativa);
                } else {
                    componente.setEnabled(!ativa);
                }
            }
        }
        
    }

    public static void limpaComponentes(JPanel painel, boolean ativa) {
        Component[] vetComponentes = (Component[]) painel.getComponents();
        for (Component componente : vetComponentes) {
            if (componente instanceof JTextField) {
                ((JTextField) componente).setText("");
                componente.setEnabled(ativa);
            } else if (componente instanceof JFormattedTextField) {
                ((JFormattedTextField) componente).setText("");
                componente.setEnabled(ativa);
            } else if (componente instanceof JComboBox) {
                ((JComboBox) componente).setSelectedIndex(-1);
                componente.setEnabled(ativa);
            } else if (componente instanceof JCheckBox) {
                ((JCheckBox) componente).setSelected(false);
                componente.setEnabled(ativa);
            } else if (componente instanceof JPasswordField) {
                ((JPasswordField) componente).setText("");
                componente.setEnabled(ativa);
            } else if (componente instanceof JRadioButton) {
                ((JRadioButton) componente).setSelected(false);
                componente.setEnabled(ativa);
            } else if (componente instanceof JTextArea) {
                ((JTextArea) componente).setText("");
                componente.setEnabled(ativa);
            } else if (componente instanceof JScrollPane) {
                // **CORREÇÃO AQUI:** Tenta pegar o componente dentro do JScrollPane
                JScrollPane scrollPane = (JScrollPane) componente;
                Component componenteAninhado = scrollPane.getViewport().getView();

                // Verifica se o componente aninhado é o JTextArea
                if (componenteAninhado instanceof JTextArea) {
                    ((JTextArea) componenteAninhado).setText("");
                    componenteAninhado.setEnabled(ativa);
                }

                // Opcional: Você pode manter o setEnabled para o JScrollPane também
                scrollPane.setEnabled(ativa);

            }
        }
    }
    
    public static void ativaDesativaBusca(JPanel painel, boolean ativa){
        Component[] vetComponentes = painel.getComponents();
        
        for (Component componente : vetComponentes) {
            if (componente instanceof JButton) {
                if ("2".equals(((JButton)componente).getActionCommand())) {
                    componente.setEnabled(ativa);
                } else {
                    componente.setEnabled(!ativa);
                }
            }
        }
        
    }
    
    public static boolean /*String*/ validaCpf(String cpf){//boolean validaCpf(String cpf){
        boolean valido=false;
        List<Integer> valor = new ArrayList<>();
        List<Integer> valor1Convertido = new ArrayList<>();
        List<Integer> valor2Preparacao = new ArrayList<>();
        List<Integer> valor2Convertido = new ArrayList<>();
        int mult = 10, soma = 0, validador1, validador2;
        
        //OBTEM SOMA:
        try {
            for (int i = 0; i < cpf.length(); i++) {
                int n = Character.getNumericValue(cpf.charAt(i));
                //int n = Integer.parseInt(String.valueOf(cpf.charAt(i)));
                valor.add(n);
            }
            
            for (int i = 0; i < 9; i++) {
                valor2Preparacao.add(valor.get(i));
                int n = valor.get(i)*mult;
                valor1Convertido.add(n);
                soma+=n;
                mult--;
            }
            
            if((11 - (soma%11))>9)
                validador1=0;
            else
                validador1 = 11 - (soma%11);
            valor2Preparacao.add(validador1);
            
            mult = 11;
            soma = 0;
            for (int i = 0; i < 10; i++) {
                int n = valor2Preparacao.get(i)*mult;
                valor2Convertido.add(n);
                soma+=n;
                mult--;
            }
            
            boolean primeiro = true;
            for (Integer val : valor2Convertido) {
                if(primeiro)
                    primeiro = false;
                else{
                    if(val == valor2Convertido.get(valor2Convertido.indexOf(val)-1));
                }
            }
            
            if((11 - (soma%11))>9)
                validador2=0;
            else
                validador2 = 11 - (soma%11);
            
            
            
            //return valor2Convertido.toString() + " = " + soma + 
              //  "\nvalidador 2: " + validador2;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        
        
        
        //validador2 = 
                
        //return valor1Convertido.toString() + " = " + soma + 
                //"\nvalidador 1: " + validador1;
        
        //return valor2Convertido.toString();
        
        /*return valor2Convertido.toString() + " = " + soma + 
                "\nvalidador 1: " + validador1;*/
        //return "resp";
        return valido;
    }
    
    public static void validaCnpj(){
        //return ;
    }
    
    //validacao manual
    public static String validaDataString(String data){
        int dia, mes, ano;

        String[] partes = data.split("/");        
        dia = Integer.parseInt(partes[0]);
        mes = Integer.parseInt(partes[1]);
        ano = Integer.parseInt(partes[2]);
        //return "dia: " + dia + "\nmes: " + mes + "\nano: " + ano;
        
        //elimina dias e meses negativos e maior que o limite e ano == 0:
        if(!(dia <= 0 || dia > 31 || mes <= 0 || mes > 12 || ano ==0)){
            //para o mes de fevereiro:
            if (mes == 2){
                //se anoBissexto = true
                if((ano%100 == 0 && ano%400 == 0)|(ano%100 > 0 && ano%4 == 0)){
                    if (!(dia > 29)){
                        return "Data válida.";
                        //return true;
                    } else 
                        return "Informe uma data válida!";
                        //return false;
                //se anoBissexto = false
                } else{
                    if (!(dia > 28)){
                        return "Data válida.";
                        //return true;
                    } else 
                        return "Informe uma data válida!";
                        //return false;
                }
            //para os meses com 31 dias:
            }else if((mes<8 && mes%2==1)|(mes>8 && mes%2==0) ){
                if (!(dia > 31)){
                    return "Data válida.";
                    //return true;
                } else 
                    return "Informe uma data válida!";
                    //return false;
            }else{
                if (!(dia > 30)){
                    return "Data válida.";
                    //return true;
                } else 
                    return "Informe uma data válida!";
                    //return false;
            }
        }else{
            return "Informe uma data válida!";
            //return false;
        }
        
    }
    
    //validacao automatica
    public static boolean validaData(String data){
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate.parse(data, dtf);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
        
    }
    
    
    public static int comparaDataString(String data1, String data2){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataForm1 = LocalDate.parse(data1, dtf);
        LocalDate dataForm2 = LocalDate.parse(data2, dtf);
        
        if(dataForm1.isAfter(dataForm2))
            return 1;
        else if(dataForm1.isEqual(dataForm2))
            return 2;
        else
            return 3;
    /*METODOS SEPARADOS (V.1.0)
    public static boolean validaDataAntigaString(String data){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataForm = LocalDate.parse(data, dtf);
        
        return (dataForm.isBefore(LocalDate.now()));
    }
    
    public static boolean validaDataFuturaString(String data){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataForm = LocalDate.parse(data, dtf);
        
        return (dataForm.isAfter(LocalDate.now()));
    }*/
    }
}

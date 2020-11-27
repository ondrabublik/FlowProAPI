package flowpro.api;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author ales
 */
public class FlowProProperties extends Properties {
	
	private String msg = "";
	
	public void load(String propertiesFilePath) throws IOException {
		msg = "file " + propertiesFilePath + " has a wrong format: ";
		
//		try {
			super.load(new FileInputStream(propertiesFilePath));
//		} catch (IOException ex) {
//            throw new IOException("unable to load file " + propertiesFilePath, ex);
//        }
	}

    public String getString(String propName) throws IOException {
        try {
            return loseComments(super.getProperty(propName));
        } catch (NullPointerException ex) {
            throw new IOException(msg + "variable " + propName + " not found", ex);
        }
    }

    public int getInt(String propName) throws IOException {
        try {
            return Integer.parseInt(loseComments(super.getProperty(propName)));
        } catch (NullPointerException ex) {
            throw new IOException(msg + "variable " + propName + " not found", ex);
        } catch (NumberFormatException ex) {
            throw new IOException(msg + "variable " + propName + " does not contain an integer", ex);
        }
    }

    public long getLong(String propName) throws IOException {
        try {
            return Long.parseLong(loseComments(super.getProperty(propName)));
        } catch (NullPointerException ex) {
            throw new IOException(msg + "variable " + propName + " not found", ex);
        } catch (NumberFormatException ex) {
            throw new IOException(msg + "variable " + propName + " does not contain an integer", ex);
        }
    }

    public double getDouble(String propName) throws IOException {
        try {
            return Double.parseDouble(loseComments(super.getProperty(propName)));
        } catch (NullPointerException ex) {
            throw new IOException(msg + "variable " + propName + " not found", ex);
        } catch (NumberFormatException ex) {
            throw new IOException(msg + "variable " + propName + " does not contain a double", ex);
        }
    }

    public boolean getBoolean(String propName) throws IOException {
        try {
            return Boolean.parseBoolean(loseComments(super.getProperty(propName)));
        } catch (NullPointerException ex) {
            throw new IOException(msg + "variable " + propName + " not found", ex);
        } catch (NumberFormatException ex) {
            throw new IOException(msg + "variable " + propName + " does not contain a boolean", ex);
        }
    }    

    public double[] getDoubleArray(String propName) throws IOException {
        try {
            return string2doubleArray(loseComments(super.getProperty(propName)));
        } catch (NullPointerException ex) {
            throw new IOException(msg + "variable " + propName + " not found", ex);
        } catch (NumberFormatException ex) {
            throw new IOException(msg + "variable " + propName + " does not contain a double", ex);
        }
    }
    
    public boolean[] getBooleanArray(String propName) throws IOException {
        try {
            return string2booleanArray(loseComments(super.getProperty(propName)));
        } catch (NullPointerException ex) {
            throw new IOException(msg + "variable " + propName + " not found", ex);
        } catch (NumberFormatException ex) {
            throw new IOException(msg + "variable " + propName + " does not contain a double", ex);
        }
    }
    
    public String[] getStringArray(String propName) throws IOException {
        try {
            String str = (loseComments(super.getProperty(propName)));
            return str.split(",");
        } catch (NullPointerException ex) {
            throw new IOException(msg + "variable " + propName + " not found", ex);
        } catch (NumberFormatException ex) {
            throw new IOException(msg + "variable " + propName + " does not contain a double", ex);
        }
    }
	
	private String loseComments(String str) {
        str = str.split("%", 2)[0];
        str = str.split("#", 2)[0];
        str = str.trim();
        //str = str.split(";", 2)[0];

        return str;
    }

    private double[] string2doubleArray(String str) {
        String[] stringArray = str.split(",");
        double[] d = new double[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            String numberAsString = stringArray[i];
            d[i] = Double.parseDouble(numberAsString);
        }
        return d;
    }
    
    private boolean[] string2booleanArray(String str) {
        String[] stringArray = str.split(",");
        boolean[] d = new boolean[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            String booleanAsString = stringArray[i];
            d[i] = Boolean.parseBoolean(booleanAsString);
        }
        return d;
    }
}

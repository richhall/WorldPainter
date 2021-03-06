/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pepsoft.worldpainter;

import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author pepijn
 */
public class Version {
    private Version() {
        // Prevent instantiation
    }
    
    public static final String VERSION;
    
    static {
        Properties versionProps = new Properties();
        try {
            versionProps.load(Version.class.getResourceAsStream("/org.pepsoft.worldpainter.properties"));
            VERSION = versionProps.getProperty("org.pepsoft.worldpainter.version");
        } catch (IOException e) {
            throw new RuntimeException("I/O error loading version number from classpath", e);
        }
    }
}
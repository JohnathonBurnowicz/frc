package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsControlModule;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.Subsystem;
import kotlin.sequences.FlatteningSequence;

public class PneumaticSubsystem implements Subsystem {
    private PneumaticsControlModule pcm;
    private Compressor compressor;

    public PneumaticSubsystem() {
        pcm = new PneumaticsControlModule(0);
        compressor = new Compressor(0, PneumaticsModuleType.CTREPCM);
        compressor.enableDigital();
     d
      //  compressor.disable();
       
      /*  boolean enabled = compressor.enabled();
        boolean  pressureSwitch = compressor.getPressureSwitchValue();
double current = compressor.getCurrent();
    
        */
    
        }

       
     
     
     
        //Compressor phCompressor = new Compressor(1, PneumaticsModuleType.CTREPCM);

        //double current = phCompressor.getPressure();
    
    

    public void setSolenoid(int solenoid, boolean state) {
    }

}


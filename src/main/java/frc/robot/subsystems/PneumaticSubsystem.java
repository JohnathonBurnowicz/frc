package frc.robot.subsystems;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;
import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PneumaticsControlModule;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.Subsystem;
import kotlin.sequences.FlatteningSequence;
import edu.wpi.first.wpilibj.TimedRobot;

public class PneumaticSubsystem implements Subsystem {
    //private PneumaticsControlModule pcm;
    //private Compressor compressor;
    private final Joystick m_controller = new Joystick(0);
     private final DoubleSolenoid m_doubleSolenoid = new DoubleSolenoid (PneumaticsModuleType.CTREPCM, 4,5);
  
    private static final int kDoubleSolenoidForward = 1 ;
    private static final int kDoubleSolenoidReverse = 2 ;
          

            public void setSolenoid(int solenoid, boolean state) {
  

              //DoubleSolenoid exampleDoublePCM = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 4, 5);


        if (this.m_controller.getRawButtonPressed(1)) {
          m_doubleSolenoid.set(kForward);

        }
      if (this.m_controller.getRawButtonPressed(2)) {
      m_doubleSolenoid.set(kReverse);
      
      }}}
    


          

       // pcm = new PneumaticsControlModule(0);
      //  compressor = new Compressor(0, PneumaticsModuleType.CTREPCM);
    //    compressor.enableDigital();
      
        //  compressor.disable();
       
       /* boolean enabled = compressor.enabled();
        boolean  pressureSwitch = compressor.getPressureSwitchValue();
double current = compressor.getCurrent();*/
    
        
    
    

       
     
     
     
        //Compressor phCompressor = new Compressor(1, PneumaticsModuleType.CTREPCM);

        //double current = phCompressor.getPressure();}
    
    

    //public void setSolenoid(int solenoid, boolean state) {
  

    //DoubleSolenoid exampleDoublePCM = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 4, 5);}}



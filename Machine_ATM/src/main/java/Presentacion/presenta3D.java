package Presentacion;

import com.sun.j3d.loaders.IncorrectFormatException;
import com.sun.j3d.loaders.ParsingErrorException;
import com.sun.j3d.loaders.Scene;
import com.sun.j3d.loaders.objectfile.ObjectFile;
import com.sun.j3d.utils.behaviors.mouse.MouseRotate;
import com.sun.j3d.utils.image.ImageException;
import com.sun.j3d.utils.universe.SimpleUniverse;
import javax.media.j3d.*;
import javax.swing.*;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;


public class presenta3D extends JPanel {

    public presenta3D(){

        GraphicsConfiguration config= SimpleUniverse.getPreferredConfiguration();
        Canvas3D canvas3D= new Canvas3D(config);

        setLayout(new BorderLayout());
        add(canvas3D);

        SimpleUniverse universo= new SimpleUniverse(canvas3D);
        universo.getViewingPlatform().setNominalViewingTransform();

         Vector3d posicionVista= new Vector3d();
         posicionVista.z=5f;
         posicionVista.x=-0.5f;
         posicionVista.y=-0.5f;

         //traslación
         Transform3D transforVista= new Transform3D();
         transforVista.setTranslation(posicionVista);

         //rotacion
         Transform3D rotacion= new Transform3D();
         rotacion.rotX(Math.toRadians(-10));
         rotacion.mul(transforVista);

         //universo.getViewingPlatform().getViewPlatformTransform().setTransform(transforVista);
           universo.getViewingPlatform().getViewPlatformTransform().setTransform(rotacion);

        BranchGroup escena= crearPincel();
        escena.compile();

        universo.addBranchGraph(escena);

    }
    public BranchGroup crearPincel(){
        BranchGroup pincel= new BranchGroup();

        TransformGroup objetoGiro= new TransformGroup();
        objetoGiro.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        objetoGiro.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
        pincel.addChild(objetoGiro);

        Alpha rotacionAlpha= new Alpha(-1,4000); //rota por si mismo
        RotationInterpolator rotacion= new RotationInterpolator(rotacionAlpha,objetoGiro);
        rotacion.setSchedulingBounds(new BoundingSphere());
        pincel.addChild(rotacion);

        /*MouseRotate mr= new MouseRotate(); //Move with mouse
        mr.setTransformGroup(objetoGiro);
        mr.setSchedulingBounds(new BoundingSphere(new Point3d(),1000f));
        pincel.addChild(mr);*/

        //carga de objeto 3D

        TransformGroup obj= new TransformGroup();
        Transform3D obj3D= new Transform3D();
        obj.getTransform(obj3D);
        obj3D.setScale(0.5);
        obj.setTransform(obj3D);

        objetoGiro.addChild(obj);

        int flags = ObjectFile.RESIZE;
        ObjectFile file= new ObjectFile(flags, (float) (49.0 * Math.PI/180.0));

        Scene scene= null;
        //String filename = "src\\main\\modelo\\intento.obj";
        String filename= null;
        //File archivo = new File(filename);

        try{
            scene= file.load(filename == null ? "src\\main\\modelo\\intento.obj" : filename);
            //scene = file.load(archivo.toURI().toURL());
            // src\\main\\readme\\modelo2.obj

        }catch (FileNotFoundException | ParsingErrorException | IncorrectFormatException  | ImageException ex) {
            System.out.println("La imagen no carga " + ex);
            throw new RuntimeException(ex);
        }

        objetoGiro.addChild(scene.getSceneGroup());

        return pincel;
    }


}

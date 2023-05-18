package Presentacion;

import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.universe.SimpleUniverse;

import javax.media.j3d.*;
import javax.swing.*;
import javax.vecmath.Vector3d;
import java.awt.*;

public class presenta3D extends JPanel {
    public presenta3D(){
        GraphicsConfiguration config= SimpleUniverse.getPreferredConfiguration();
        Canvas3D canvas3D= new Canvas3D(config);

        setLayout(new BorderLayout());
        add(canvas3D);

        SimpleUniverse unicerso= new SimpleUniverse(canvas3D);
        //unicerso.getViewingPlatform().setNominalViewingTransform();

        Vector3d posicionVista= new Vector3d();
        posicionVista.z=3f;
        posicionVista.x=0f;
        posicionVista.y=0f;

        //traslación
        Transform3D transforVista= new Transform3D();
        transforVista.setTranslation(posicionVista);
        //rotacion
        Transform3D rotacion= new Transform3D();
        rotacion.rotX(Math.toRadians(-15));
        rotacion.mul(transforVista);

        //unicerso.getViewingPlatform().getViewPlatformTransform().setTransform(transforVista);
        unicerso.getViewingPlatform().getViewPlatformTransform().setTransform(rotacion);

        BranchGroup escena= crearPincel();
        escena.compile();

        //unicerso.addBranchGraph(escena);

    }

    public BranchGroup crearPincel(){
        BranchGroup pincel= new BranchGroup();

        TransformGroup objetoGiro= new TransformGroup();
        objetoGiro.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        pincel.addChild(objetoGiro);

        ColorCube cubo = new ColorCube(0.5f);
        objetoGiro.addChild(cubo);

        Alpha rotacionAlpha= new Alpha(-1,4000);

        RotationInterpolator rotacion= new RotationInterpolator(rotacionAlpha,objetoGiro);
        rotacion.setSchedulingBounds(new BoundingSphere());
        pincel.addChild(rotacion);

        return pincel;
    }
}

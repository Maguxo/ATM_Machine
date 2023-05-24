package Presentacion;

import com.sun.j3d.utils.behaviors.mouse.MouseRotate;
import com.sun.j3d.utils.image.TextureLoader;
import com.sun.j3d.utils.universe.SimpleUniverse;
import javax.media.j3d.*;
import javax.swing.*;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Point3f;
import javax.vecmath.Vector3d;
import java.awt.*;


public class presenta3D extends JPanel {
    public presenta3D(){
        GraphicsConfiguration config= SimpleUniverse.getPreferredConfiguration();
        Canvas3D canvas3D= new Canvas3D(config);

        setLayout(new BorderLayout());
        add(canvas3D);

        SimpleUniverse universo= new SimpleUniverse(canvas3D);
        universo.getViewingPlatform().setNominalViewingTransform();

     Vector3d posicionVista= new Vector3d();
         posicionVista.z=2f;
         posicionVista.x=0f;
         posicionVista.y=0f;

         //traslación
         Transform3D transforVista= new Transform3D();
         transforVista.setTranslation(posicionVista);

         //rotacion
         Transform3D rotacion= new Transform3D();
         rotacion.rotX(Math.toRadians(80));
         rotacion.mul(transforVista);

         //universo.getViewingPlatform().getViewPlatformTransform().setTransform(transforVista);
           universo.getViewingPlatform().getViewPlatformTransform().setTransform(rotacion);

        BranchGroup escena= crearPincel();
        escena.compile();

        universo.addBranchGraph(escena);

    }
    public BranchGroup crearPincel(){
        BranchGroup pincel= new BranchGroup();

        int []puntosRed= new int[1]; //rectangle
        puntosRed[0]=4;
        TriangleFanArray cuadrado= new TriangleFanArray(4,TriangleFanArray.COORDINATES|
                                       TriangleFanArray.COLOR_3,puntosRed);
        cuadrado.setCoordinate(0, new Point3f(-0.5f,0.5f,0f));
        cuadrado.setCoordinate(1, new Point3f(0.5f,0.5f,0f));
        cuadrado.setCoordinate(2, new Point3f(0.5f,-0.5f,0f));
        cuadrado.setCoordinate(3, new Point3f(-0.5f,-0.5f,0f));

        int []puntos= new int[1];//rectangulo2
        puntos[0]=4;
        TriangleFanArray rectangulo= new TriangleFanArray(4,TriangleFanArray.COORDINATES|
                                         TriangleFanArray.COLOR_3,puntos);
        rectangulo.setCoordinate(0, new Point3f(-0.3f,0.7f,0.01f));
        rectangulo.setCoordinate(1, new Point3f(0.3f,0.7f,0.01f));
        rectangulo.setCoordinate(2, new Point3f(0.3f,0.3f,0.01f));
        rectangulo.setCoordinate(3, new Point3f(-0.3f,0.3f,0.01f));
        for(int i=0; i<4;i++) rectangulo.setColor(i, new Color3f(Color.CYAN));

        int []escalerab= new int[1];//base de escalera
        escalerab[0]=4;
        TriangleFanArray bescalera= new TriangleFanArray(4,TriangleFanArray.COORDINATES|
                                        TriangleFanArray.COLOR_3,escalerab);
        bescalera.setCoordinate(0, new Point3f(-0.15f,0.3f,0.01f));
        bescalera.setCoordinate(1, new Point3f(0.15f,0.3f,0.01f));
        bescalera.setCoordinate(2, new Point3f(0.15f,0.2f,0.01f));
        bescalera.setCoordinate(3, new Point3f(-0.15f,0.2f,0.01f));
        for(int i=0; i<4;i++) bescalera.setColor(i, new Color3f(Color.CYAN));


        TransformGroup objetoGiro= new TransformGroup();
        objetoGiro.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        objetoGiro.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
        pincel.addChild(objetoGiro);

        Appearance app= new Appearance();
        app.setPolygonAttributes(new PolygonAttributes(PolygonAttributes.POLYGON_FILL,PolygonAttributes.CULL_NONE,0f));

        objetoGiro.addChild(new Shape3D(cuadrado,app()));
        objetoGiro.addChild(new Shape3D(rectangulo,app));
        objetoGiro.addChild(new Shape3D(bescalera,app));

        /*Alpha rotacionAlpha= new Alpha(-1,4000); //rota por si mismo
        RotationInterpolator rotacion= new RotationInterpolator(rotacionAlpha,objetoGiro);
        rotacion.setSchedulingBounds(new BoundingSphere());
        pincel.addChild(rotacion);*/

        MouseRotate mr= new MouseRotate(); //Move with mouse
        mr.setTransformGroup(objetoGiro);
        mr.setSchedulingBounds(new BoundingSphere(new Point3d(),1000f));
        pincel.addChild(mr);
        return pincel;
    }
    Appearance app(){
        Appearance apariencia= new Appearance();
        TexCoordGeneration texCoor= new TexCoordGeneration(
                TexCoordGeneration.OBJECT_LINEAR,TexCoordGeneration.TEXTURE_COORDINATE_2
        );
        apariencia.setTexCoordGeneration(texCoor);

        String cara= "src/main/imagenes/cuadricula.jpg";

        TextureLoader loader= new TextureLoader(cara,this);
        ImageComponent2D imagen=  loader.getImage();
        Texture2D textura= new Texture2D(Texture.BASE_LEVEL,Texture.RGBA,imagen.getWidth(),imagen.getHeight());
        textura.setImage(0,imagen);
        textura.setEnable(true);

        textura.setMagFilter(Texture.BASE_LEVEL_LINEAR);
        textura.setMinFilter(Texture.BASE_LEVEL_LINEAR);

        apariencia.setTexture(textura);
        apariencia.setPolygonAttributes(new PolygonAttributes(PolygonAttributes.POLYGON_FILL,PolygonAttributes.CULL_NONE,0f));
        apariencia.setTextureAttributes(new TextureAttributes());

        return apariencia;
    }

}

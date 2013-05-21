package org.thcic.xapx.captcha;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import com.octo.captcha.component.image.backgroundgenerator.BackgroundGenerator;
import com.octo.captcha.component.image.backgroundgenerator.UniColorBackgroundGenerator;
import com.octo.captcha.component.image.color.RandomListColorGenerator;
import com.octo.captcha.component.image.deformation.ImageDeformation;
import com.octo.captcha.component.image.fontgenerator.FontGenerator;
import com.octo.captcha.component.image.fontgenerator.RandomFontGenerator;
import com.octo.captcha.component.image.textpaster.GlyphsPaster;
import com.octo.captcha.component.image.textpaster.TextPaster;
import com.octo.captcha.component.image.textpaster.glyphsvisitor.GlyphsVisitors;
import com.octo.captcha.component.image.textpaster.glyphsvisitor.OverlapGlyphsUsingShapeVisitor;
import com.octo.captcha.component.image.textpaster.glyphsvisitor.TranslateAllToRandomPointVisitor;
import com.octo.captcha.component.image.textpaster.glyphsvisitor.TranslateGlyphsVerticalRandomVisitor;
import com.octo.captcha.component.image.wordtoimage.DeformedComposedWordToImage;
import com.octo.captcha.component.image.wordtoimage.WordToImage;
import com.octo.captcha.component.word.wordgenerator.RandomWordGenerator;
import com.octo.captcha.component.word.wordgenerator.WordGenerator;
import com.octo.captcha.engine.image.ListImageCaptchaEngine;
import com.octo.captcha.image.gimpy.GimpyFactory;

public class GmailCaptchaEngine extends ListImageCaptchaEngine {

	@Override
	protected void buildInitialFactories() {
		WordGenerator dictionnaryWords = new RandomWordGenerator("ABCDEFGHJKLMNRSWXY345689");

	    TextPaster randomPaster = new GlyphsPaster(
	    		Integer.valueOf(4),
	    		Integer.valueOf(4),
	    		new RandomListColorGenerator(new Color[] { new Color(23, 170, 27), new Color(220, 34, 11), new Color(23, 67, 172) }),
	    		new GlyphsVisitors[] {
	    			new TranslateGlyphsVerticalRandomVisitor(1.0D),
	    			new OverlapGlyphsUsingShapeVisitor(2.0D),
					new TranslateAllToRandomPointVisitor()
	    		}
	    );

	    BackgroundGenerator back = new UniColorBackgroundGenerator(Integer.valueOf(64), Integer.valueOf(30), new Color(250,250,250));

	    FontGenerator shearedFont = new RandomFontGenerator(
	    		Integer.valueOf(20),
	    		Integer.valueOf(20),
	    		new Font[] { new Font("nyala", 1, 50), new Font("Bell MT", 0, 50), new Font("Credit valley", 1, 50) }, false);

	    /*
	    PinchFilter pinch = new PinchFilter();
	    pinch.setAmount(-0.5F);
	    pinch.setRadius(10.0F);
	    pinch.setAngle(0.1963496F);
	    pinch.setCentreX(0.5F);
	    pinch.setCentreY(-0.01F);
	    pinch.setEdgeAction(1);

	    PinchFilter pinch2 = new PinchFilter();
	    pinch2.setAmount(-0.6F);
	    pinch2.setRadius(20.0F);
	    pinch2.setAngle(0.1963496F);
	    pinch2.setCentreX(0.3F);
	    pinch2.setCentreY(1.01F);
	    pinch2.setEdgeAction(1);

	    PinchFilter pinch3 = new PinchFilter();
	    pinch3.setAmount(-0.6F);
	    pinch3.setRadius(20.0F);
	    pinch3.setAngle(0.1963496F);
	    pinch3.setCentreX(0.8F);
	    pinch3.setCentreY(-0.01F);
	    pinch3.setEdgeAction(1);
	    */

	    List<ImageDeformation> textDef = new ArrayList<ImageDeformation>();
	    //textDef.add(new ImageDeformationByBufferedImageOp(pinch));
	    //textDef.add(new ImageDeformationByBufferedImageOp(pinch2));
	    //textDef.add(new ImageDeformationByBufferedImageOp(pinch3));

		WordToImage word2image = new DeformedComposedWordToImage(false,
				shearedFont, back, randomPaster,
				new ArrayList<ImageDeformation>(),
				new ArrayList<ImageDeformation>(), textDef);

	    addFactory(new GimpyFactory(dictionnaryWords, word2image, false));
	}

}
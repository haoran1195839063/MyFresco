package com.example.com.fresco1;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private SimpleDraweeView simple;
    private Uri parse;
    private GenericDraweeHierarchyBuilder builder;
    private Button yuanjiao;
    private Button yuanxing;
    private Button bili;
    private Button jianjin;
    private Button cipan;
    private Button donghua;
    private Button jianting;
    private Button okhttp;
    private String lujing = "http://www.people.com.cn/mediafile/pic/20161022/76/4315084153778263996.jpg";
    private AbstractDraweeController build1;
    private AbstractDraweeController build11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        simple = (SimpleDraweeView) findViewById(R.id.simple);
        parse = Uri.parse(lujing);
        simple.setImageURI(parse);
        builder = new GenericDraweeHierarchyBuilder(getResources());


        yuanjiao = (Button) findViewById(R.id.yuanjiao);
        yuanjiao.setOnClickListener(this);
        yuanxing = (Button) findViewById(R.id.yuanxing);
        yuanxing.setOnClickListener(this);
        bili = (Button) findViewById(R.id.bili);
        bili.setOnClickListener(this);
        jianjin = (Button) findViewById(R.id.jianjin);
        jianjin.setOnClickListener(this);
        cipan = (Button) findViewById(R.id.cipan);
        cipan.setOnClickListener(this);
        donghua = (Button) findViewById(R.id.donghua);
        donghua.setOnClickListener(this);
        jianting = (Button) findViewById(R.id.jianting);
        jianting.setOnClickListener(this);
        okhttp = (Button) findViewById(R.id.okhttp);
        okhttp.setOnClickListener(this);


        build11 = Fresco.newDraweeControllerBuilder()
                .setUri(lujing)
                .setTapToRetryEnabled(true)
                .build();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.yuanjiao:
                GenericDraweeHierarchy build2 = builder.setRoundingParams(RoundingParams.fromCornersRadius(10)).build();
                simple.setHierarchy(build2);

                simple.setController(build11);
                break;
            case R.id.yuanxing:
                //代码实现圆形
                GenericDraweeHierarchy build = builder.setRoundingParams(RoundingParams.asCircle()).setFadeDuration(5000).build();
                simple.setHierarchy(build);


                simple.setController(build11);
                break;
            case R.id.bili:
                simple.setAspectRatio(1.2f);

                simple.setController(build11);

                break;
            case R.id.jianjin:
                ImageRequest request = ImageRequestBuilder.newBuilderWithSource(parse)
                        .setProgressiveRenderingEnabled(true)
                        .build();
                DraweeController controller = Fresco.newDraweeControllerBuilder()
                        .setImageRequest(request)
                        .setOldController(simple.getController())
                        .build();

                simple.setController(controller);

                break;
            case R.id.cipan:

                break;
            case R.id.donghua:

                break;
            case R.id.jianting:

                break;
            case R.id.okhttp:

                break;
        }
    }
}

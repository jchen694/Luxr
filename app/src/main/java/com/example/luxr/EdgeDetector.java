package com.example.luxr;

import android.graphics.Bitmap;

import org.opencv.android.Utils;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by juliachen on 6/26/17.
 */

public class EdgeDetector {

    Bitmap currentImage;
    Bitmap contourImage;
    Mat rgba;
    Mat hierarchy;
    List<MatOfPoint> contours;
    int threshold = 50;

    EdgeDetector(Bitmap bitmap) {
        rgba = new Mat();
        Utils.bitmapToMat(bitmap, rgba);
        Mat edges = new Mat(rgba.size(), CvType.CV_8UC1);
        rgba.convertTo(rgba, CvType.CV_8UC1);
        Imgproc.cvtColor(rgba, edges, Imgproc.COLOR_RGB2GRAY, 4);
        Imgproc.blur(edges, edges, new Size(3, 3));
        Imgproc.Canny(edges, edges, threshold, threshold * 2,  3, false);

//        Mat dest = new Mat(rgba.size(), CvType.CV_8UC1);
//        Core.add(dest, Scalar.all(0), dest);
//        Mat white = new Mat(rgba.size(), CvType.CV_8UC1);
//        Core.add(white, Scalar.all(255), white);
//        white.copyTo(dest, edges);

        //BitmapHelper.showBitmap(this, bitmap, imgPic);
        Bitmap resultBitmap = Bitmap.createBitmap(edges.cols(), edges.rows(), Bitmap.Config.ARGB_8888);
        //Utils.matToBitmap(edges, resultBitmap);
        //BitmapHelper.showBitmap(this, resultBitmap, detectEdgesImageView);
        currentImage = resultBitmap;


        //#JANK

        //contours stuff
        //drawContours init
        contours = new ArrayList<>();
        contours.clear();
        hierarchy = new Mat();
        Imgproc.findContours(edges, contours, hierarchy, Imgproc.RETR_LIST, Imgproc.CHAIN_APPROX_SIMPLE);
        //drawContours init
        Mat drawMat = new Mat(edges.size(), edges.type());
        //if any contour exists
        if (hierarchy.size().height > 0 && hierarchy.size().width > 0) {
            System.out.println("Found Contour");
            //for each contour, display it in blue
            Scalar color = new Scalar(255, 255, 0);
            Imgproc.drawContours(drawMat, contours, -1, color, 2);
//            for (int i = 0; i < contours.size(); i++) {
//                Scalar color = new Scalar(255, 255, 255);
//                Imgproc.drawContours(drawMat, contours, i, color, 2);
//                //Imgproc.drawContours(drawMat, contours, i, color, 3, 8, hierarchy, 0, new Point(1, 1));
//            }
        }
//
//        //Bitmap
        Bitmap resultOtherBitmap = Bitmap.createBitmap(drawMat.cols(), drawMat.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(drawMat, resultOtherBitmap);
        contourImage = resultOtherBitmap;

    }



}

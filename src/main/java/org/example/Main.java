package org.example;



import org.bytedeco.opencv.global.opencv_core;
import org.bytedeco.opencv.global.opencv_imgcodecs;
import org.bytedeco.opencv.global.opencv_imgproc;
import org.bytedeco.opencv.opencv_core.Mat;
import org.example.letter.CompareLauncher;


import java.util.Arrays;


public class Main {

    private static final CompareLauncher compareLauncher = new CompareLauncher();



    public static void main(String[] args) {

        // Загружаем два изображения
        Mat img1 = opencv_imgcodecs.imread("src/main/resources/putin.jpg");
        Mat img2 = opencv_imgcodecs.imread("src/main/resources/elon.jpg");

        // Проверяем, что изображения загружены
        if (img1.empty() || img2.empty()) {
            System.err.println("Ошибка загрузки изображений!");
            return;
        }

        // Делаем изображения одного размера (если они разные)
        opencv_imgproc.resize(img2, img2, img1.size());

        // Вычисляем абсолютную разницу
        Mat diff = new Mat();
        opencv_core.absdiff(img1, img2, diff);

        // Конвертируем разницу в градации серого
        Mat grayDiff = new Mat();
        opencv_imgproc.cvtColor(diff, grayDiff, opencv_imgproc.COLOR_BGR2GRAY);

        // Применяем пороговую фильтрацию
        Mat thresholdDiff = new Mat();
        opencv_imgproc.threshold(grayDiff, thresholdDiff, 30, 255, opencv_imgproc.THRESH_BINARY);

        // Вычисляем процент различий
        double nonZeroPixels = opencv_core.countNonZero(thresholdDiff);
        double totalPixels = thresholdDiff.rows() * thresholdDiff.cols();
        double differencePercent = (nonZeroPixels / totalPixels) * 100;

        System.out.printf("Изображения отличаются на %.2f%%\n", differencePercent);

        // Сохраняем разницу для визуализации
        opencv_imgcodecs.imwrite("difference.jpg", thresholdDiff);


    }


}

package org.grecha.service;

import lombok.RequiredArgsConstructor;
import org.grecha.entity.Area;
import org.grecha.entity.Specialty;
import org.springframework.stereotype.Component;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class ExpertSystem {
    private final AreaService areaService;
    private final Scanner scanner = new Scanner(System.in);
    private PrintStream ps;

    public void start() {
        initPrintStream();

        showMessage("Добро пожаловать в систему подбора онлайн курсов!\n");
        showMessage("Выберите интересующее Вас направление:\n");

        Area selectedArea = getSelectedArea();
        showInfoAboutSpecialties(selectedArea);
        //TODO("На данный момент получаем специальности по выбранному направлению, сделать дальше выбор того, что интересно человеку изучить и на основе этого выдавать курсы")
        System.exit(0);
    }

    private Area getSelectedArea() {
        List<Area> areas = areaService.getAllAreas();

        for (int i = 0; i < areas.size(); i++) {
            showMessage((i + 1) + "\t" + areas.get(i).getName() + "\n");
        }

        showMessage("Введите цифру направления: ");

        int selectedAreaNumber = scanner.nextInt();
        if (selectedAreaNumber - 1 >= areas.size()) {
            showMessage("Ошибка! Такого направления не существует! \n");
            System.exit(0);
        }

        return areas.get(selectedAreaNumber - 1);
    }

    private void showInfoAboutSpecialties(Area selectedArea) {
        showMessage("Выберите специальность по выбранному Вами направлению: \n");

        List<Specialty> selectedAreaSpecialties = selectedArea.getSpecialties();
        for (int i = 0; i < selectedAreaSpecialties.size(); i++) {
            showMessage((i + 1) + "\t" + selectedAreaSpecialties.get(i).getName() + "\n");
        }
    }

    private void initPrintStream() {
        try {
            ps = new PrintStream(System.out, true, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private void showMessage(String text) {
        ps.print(text);
    }
}

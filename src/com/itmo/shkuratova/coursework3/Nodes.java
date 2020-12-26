package com.itmo.shkuratova.coursework3;

import java.util.ArrayList;

/**
 * class Nodes
 * contains legend of game
 * help to moves to the next node depending by player's choice
 *
 * @author Kate Shkuratova
 * @version 1.1
 * @see ChainNodes
 */
public class Nodes {
    public static final String START = "Начало";

    public static ChainNodes createNodes(String state) {
        ArrayList<ChainNodes> nodes = new ArrayList<>(15);

        ChainNodes fox = new StepChoice("Начало", "Каждое утро Лисёнок просыпался, завтракал и шёл увидеться с Бельчонком.\nЭто утро не было исключением. Лисёнок пришёл на их обычное место встречи, но Бельчонка там не было.\nЛисёнок ждал, ждал, но так и не смог дождаться своего друга. \"Бельчонок не пропустил еще ни одной встречи, вдруг он попал в беду.\" - подумал Лисёнок.\nКак поступить Лисенку?\n");
        ChainNodes home = new StepChoice("Вернуться домой", "Вернувшись домой, Лисёнок нашёл там Бельчонка.\nОказалось, что Бельчонок пришёл на место встречи раньше и увидел там рой злобных пчел.\nОн поспешил предупредить об этом Лисёнка, но они разминулись. Наконец-то друзья нашли друг друга!\nИгра завершилась успехом.\n");
        ChainNodes search = new StepChoice("Отправиться на поиски", "Все лесные жители были заняты своими делами и не обращали внимания на Лисёнка и его проблему.\nНо вдруг кто нибудь видел Бельчонка... Лисёнок не знал, что ему делать.\nПомогите ему.\n");
        ChainNodes forestDwellers = new StepChoice("Попытаться разузнать о Бельчонке у лесных жителей", "Пока Лисёнок принимал решение, лесные жители разошлись кто куда.\nОстались только Сова и Волк. Но у Совы бывают проблемы с памятью, а Волк может сильно разозлиться из-за расспросов.\nКого выбрать?\n");
        ChainNodes singleton = new StepChoice("Искать Бельчонка в одиночку", "Лисёнок слишком долго плутал по лесу в поисках друга и сам не заметил, как заблудился.\nТеперь его самого нужно искать.\nИгра завершилась неудачей.");
        ChainNodes owl = new StepChoice("Расспросить Сову", "Сова долго не хотела говорить, но в итоге сказала, что видела испуганного Бельчонка, бежавшего в глубь леса.\nВсе лесные жители знают, что в глубине леса опасно,\nесли Бельчонок там, ему срочно нужна помощь.\n");
        ChainNodes wolf = new StepChoice("Расспросить Волка", "Волк оказался вполне дружелюбным, но помочь не смог.\nЛишь сказал, что маленькому лисенку не стоит бродить по лесу одному.\nИ как теперь поступить?\n");
        ChainNodes deepForest = new StepChoice("Поверить Сове и отправиться в глубь леса", "В глубине леса Лисёнок встретил Медвежонка. Ленивый Медвежонок был готов рассказать все, что знает,\nесли Лисёнок принесёт ему мёда.\n");
        ChainNodes getHoney = new StepChoice("Нужно воспользоваться шансом и раздобыть мёд", "Лисёнок быстро нашёл мёд, но вокруг летал рой злобных пчел. Лисёнок всегда боялся пчёл,\nно и не найти друга он тоже боялся.\n");
        ChainNodes bees = new StepChoice("Подождать, вдруг пчёлы улетят", "Лисёнок подождал немного, и пчёлы разлетелись.\nЛисёнок без проблем набрал мёда. Вдруг он понял, что очень голоден.\nЧто же делать?\n");
        ChainNodes honeyThief = new StepChoice("Нужно попытаться выкрасть мёд немедленно", "Это была не лучшая идея. Пчёлы покусали Лисёнка, теперь ему самому нужна помощь.\nИгра закончилась неудачей.\n");
        ChainNodes rest = new StepChoice("Поесть немного и передохнуть", "Пока Лисёнок ел, злобные пчёлы вернулись и покусали его.\nЛисёнку нужна помощь, он не сможет продолжить поиски.\nИгра завершилась неудачей.\n");
        ChainNodes teddyBear = new StepChoice("Скорее отнести мёд Медвежонку", "Довольный Медвежонок рассказал Лисёнку, что очень хорошо знает семью Белок и уверен,\nчто Бельчонок никогда не пошёл бы в глубь леса. Он заверял Лисёнка, что Белки не попадают в неприятности, и что Совам нельзя верить,\nон также уговаривал Лисёнка вернуться домой.\n");

        ChainNodes empty = new StepChoice("", "");

        fox.handleRequest();
        fox.setFirstChoice(home).setSecondChoice(search);
        home.setFirstChoice(empty).setSecondChoice(empty);
        singleton.setFirstChoice(empty).setSecondChoice(empty);
        honeyThief.setFirstChoice(empty).setSecondChoice(empty);
        search.setFirstChoice(forestDwellers).setSecondChoice(singleton);
        forestDwellers.setFirstChoice(owl).setSecondChoice(wolf);
        owl.setFirstChoice(deepForest).setSecondChoice(singleton);
        wolf.setFirstChoice(home).setSecondChoice(singleton);
        deepForest.setFirstChoice(singleton).setSecondChoice(getHoney);
        getHoney.setFirstChoice(bees).setSecondChoice(honeyThief);
        bees.setFirstChoice(rest).setSecondChoice(teddyBear);
        teddyBear.setFirstChoice(singleton).setSecondChoice(home);

        nodes.add(fox);
        nodes.add(home);
        nodes.add(search);
        nodes.add(forestDwellers);
        nodes.add(singleton);
        nodes.add(owl);
        nodes.add(wolf);
        nodes.add(deepForest);
        nodes.add(getHoney);
        nodes.add(bees);
        nodes.add(honeyThief);
        nodes.add(rest);
        nodes.add(teddyBear);

        for (ChainNodes node : nodes)
            if (node.getGameState().equals(state)) {
                return node;
            }
        return null;
    }
}

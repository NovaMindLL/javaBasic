
import java.util.*;

public class Piesa2 {
    public static void main(String[] args) {
        // Массив, содержащий список ролей
        String[] roles = new String[]{
                "Городничий",
                "Аммос Федорович",
                "Артемий Филиппович",
                "Лука",
                "Лука Лукич"
        };
        // Массив, содержащий строки сценария
        String[] textLines = new String[]{
                "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                "Аммос Федорович: Как ревизор?",
                "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!",
                "Лука: Господи боже! Я уронил своё пасхальное яйцо от неожиданности!"
        };
        // Выводим результат работы метода на экран
        System.out.println(printTextPerRole(roles, textLines));
    }

    /**
     * Группирует строки сценария по ролям, нумерует их и возвращает результат в виде готового текста.
     *
     * @param roles     Массив строк с именами ролей.
     * @param textLines Массив строк со строками сценария.
     * @return Отформатированная строка с репликами, сгруппированными по ролям.
     */
    private static String printTextPerRole(String[] roles, String[] textLines) {

        Map<String, List<String>> roleTextMap = new LinkedHashMap<>();

        for (String role : roles) {
            roleTextMap.put(role, new ArrayList<>());
        }

        for (int i = 0; i < textLines.length; i++) {
            for (String role : roles) {
                if (textLines[i].startsWith(role + ": ")) {
                    String text = textLines[i].substring(role.length() + 1).trim();
                    roleTextMap.get(role).add((i + 1) + ") " + text);
                    break;
                }
            }
        }
        StringBuilder result = new StringBuilder();

        for (String role : roles) {
            result.append(role).append(":\n");
            List<String> lines = roleTextMap.get(role);
            for (String line : lines) {
                result.append(line).append("\n");
            }
            result.append("\n");
        }

        return result.toString().trim();
    }
}
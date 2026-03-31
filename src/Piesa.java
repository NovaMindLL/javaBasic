import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;

public class Piesa {
    public static void main (String[] args){
        // Массив, содержащий список ролей
        String[] roles = new String[]{
                "Городничий",
                "Аммос Федорович",
                "Артемий Филиппович",
                "Лук",
                "Лука",
                "Лука Лукич"
        };
        // Массив, содержащий строки сценария
        String[] textLines = new String[]{
                "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие к нам едет ревизор.",
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
     * Оптимизированная версия.
     *
     * @param roles     Массив строк с именами ролей.
     * @param textLines Массив строк со строками сценария.
     * @return Отформатированная строка с репликами, сгруппированными по ролям.
     */
    private static String printTextPerRole(String[] roles, String[] textLines) {
        // *** ОПТИМИЗАЦИЯ: Используем LinkedHashMap для сохранения порядка ролей без дополнительной сортировки. ***
        Map<String, List<String>> roleTextMap = new LinkedHashMap<>();
        for (String role : roles) {
            roleTextMap.put(role, new ArrayList<>());
        }

        // *** ОПТИМИЗАЦИЯ: Обрабатываем все строки за один проход (сложность O(N)). ***
        for (int i = 0; i < textLines.length; i++) {
            String line = textLines[i];
            // *** ОПТИМИЗАЦИЯ: Находим роль, извлекая текст до первого двоеточия, вместо перебора всех ролей. ***
            int colonIndex = line.indexOf(':');
            
            if (colonIndex != -1) {
                String role = line.substring(0, colonIndex);
                // *** ОПТИМИЗАЦИЯ: Быстрая проверка существования роли в Map (сложность O(1)). ***
                if (roleTextMap.containsKey(role)) {
                    String text = line.substring(colonIndex + 1).trim();
                    roleTextMap.get(role).add((i + 1) + ") " + text);
                }
            }
        }

        // *** ОПТИМИЗАЦИЯ: Предварительная оценка размера итоговой строки для StringBuilder. ***
        // Это позволяет избежать множественных перевыделений памяти.
        int estimatedCapacity = 0;
        for (String line : textLines) {
            estimatedCapacity += line.length(); // Длина самой строки
        }
        // Добавляем примерный запас на имена ролей, номера строк, двоеточия, скобки и переводы строк.
        // Примерно 10 символов на каждую реплику + 20 символов на каждую роль.
        estimatedCapacity += textLines.length * 10 + roles.length * 20; 

        StringBuilder result = new StringBuilder(estimatedCapacity);
        // *** ОПТИМИЗАЦИЯ: Итерируемся по LinkedHashMap, который уже сохранил правильный порядок ролей. ***
        for (Map.Entry<String, List<String>> entry : roleTextMap.entrySet()) {
            result.append(entry.getKey()).append(":\n");
            for (String line : entry.getValue()) {
                result.append(line).append("\n");
            }
            result.append("\n");
        }

        // Возвращаем итоговую строку, убрав лишние пробелы или переносы в самом конце.
        return result.toString().trim();
    }
}

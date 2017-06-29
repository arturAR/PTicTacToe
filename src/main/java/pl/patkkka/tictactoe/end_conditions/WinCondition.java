package pl.patkkka.tictactoe.end_conditions;

import pl.patkkka.tictactoe.Board;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Patka on 2017-05-29.
 */
public abstract class WinCondition {

    public WinCondition() {
    }

    public abstract boolean checkCondition(char currentChar, Board board);

    public static <T, E> Set<T> getKeysByValue(Map<T, E> map, E value) {
        return map.entrySet()
                .stream()
                .filter(entry -> Objects.equals(entry.getValue(), value))
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }
}

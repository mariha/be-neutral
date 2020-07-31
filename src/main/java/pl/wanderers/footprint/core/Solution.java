package pl.wanderers.footprint.core;

import java.util.Objects;

public class Solution {
    private String _id;
    private String _ver;

    private final String name;

    public Solution(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solution solution = (Solution) o;

        if (_id == null || solution._id == null) {
            return Objects.equals(name, solution.name);
        }

        return Objects.equals(_id, solution._id) &&
                Objects.equals(_ver, solution._ver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, _ver);
    }

    @Override
    public String toString() {
        return "Solution{" +
                "_id='" + _id + '\'' +
                ", _ver='" + _ver + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

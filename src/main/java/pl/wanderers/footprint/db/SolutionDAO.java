package pl.wanderers.footprint.db;

import com.cloudant.client.api.Database;
import com.cloudant.client.api.query.Expression;
import com.cloudant.client.api.query.QueryBuilder;
import com.cloudant.client.api.query.QueryResult;

import java.util.List;
import java.util.Optional;

import pl.wanderers.footprint.core.Solution;

public class SolutionDAO {

    private final Database db;

    public SolutionDAO(DatabaseService dbService) {
        this.db = dbService.getDb();
    }

    public Optional<Solution> findById(long id) {
        if (db.contains(Long.toString(id))) {
            return Optional.of(db.find(Solution.class, Long.toString(id)));
        } else {
            return Optional.empty();
        }
    }

    public List<Solution> findAll() {
        QueryResult<Solution> query = db.query(new QueryBuilder(Expression.all("*")).build(), Solution.class);
        // todo pages
        return query.getDocs();
    }

    public void create(Solution solution) {
        db.save(solution);
    }
}

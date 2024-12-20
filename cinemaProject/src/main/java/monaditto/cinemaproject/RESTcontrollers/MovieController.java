package monaditto.cinemaproject.RESTcontrollers;

import monaditto.cinemaproject.movie.CreateMovieStatus;
import monaditto.cinemaproject.movie.MovieDto;
import monaditto.cinemaproject.movie.MovieService;
import monaditto.cinemaproject.status.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/movies")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PutMapping("/create")
    public ResponseEntity<String> createMovie(@RequestBody MovieDto movieDto) {
        Status createMovieStatus = movieService.createMovie(movieDto);

        if (createMovieStatus.isSuccess()) {
            return ResponseEntity.ok(createMovieStatus.message());
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(createMovieStatus.message());
    }

    @PutMapping("/edit/add-categories/{id}")
    public ResponseEntity<String> addCategories(@PathVariable Long id, @RequestBody List<Long> categoryIds) {
        Status addCategoriesStatus = movieService.addCategories(id, categoryIds);

        if (addCategoriesStatus.isSuccess()) {
            return ResponseEntity.ok(addCategoriesStatus.message());
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(addCategoriesStatus.message());
    }
}

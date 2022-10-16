INSERT INTO `api_disney`.`roles` (`id`, `name`) VALUES ('1', 'ROLE_USER');
INSERT INTO `api_disney`.`roles` (`id`, `name`) VALUES ('2', 'ROLE_ADMIN');

INSERT INTO `api_disney`.`genres` (`id_genre`, `image`, `name`) VALUES ('1', 'aventura.jpg', 'Aventura');
INSERT INTO `api_disney`.`genres` (`id_genre`, `image`, `name`) VALUES ('2', 'animacion.jpg', 'Animacion');
INSERT INTO `api_disney`.`genres` (`id_genre`, `image`, `name`) VALUES ('3', 'musical.jpg', 'Musical');
INSERT INTO `api_disney`.`genres` (`id_genre`, `image`, `name`) VALUES ('4', 'fantasia.jpg', 'Fantasia');

INSERT INTO `api_disney`.`movies` (`id_movie`, `calification`, `creation_date`, `image`, `title`, `genre_id`) VALUES ('1', '5', '1994-07-13', 'reyLeon.jpg', 'El rey Leon', '1');
INSERT INTO `api_disney`.`movies` (`id_movie`, `calification`, `creation_date`, `image`, `title`, `genre_id`) VALUES ('2', '4', '2013-06-14', 'frozzen.jpg', 'Frozzen', '2');
INSERT INTO `api_disney`.`movies` (`id_movie`, `calification`, `creation_date`, `image`, `title`, `genre_id`) VALUES ('3', '5', '1989-12-07', 'laSirenita.jpg', 'La sirenita', '1');

INSERT INTO `api_disney`.`characters` (`id_character`, `age`, `history`, `image`, `name`, `weight`) VALUES ('1', '9', 'Valiente e inocente, la princesa Anna se embarca en una aventura congelada para salvar a su reino', 'anna.jpg', 'Anna', '45');
INSERT INTO `api_disney`.`characters` (`id_character`, `age`, `history`, `image`, `name`, `weight`) VALUES ('2', '28', 'Simba es el personaje protagonista de la trilogía de películas El rey león', 'simba.jpg', 'Simba', '55');
INSERT INTO `api_disney`.`characters` (`id_character`, `age`, `history`, `image`, `name`, `weight`) VALUES ('3', '38', 'El Rey Mufasa es un personaje principal de la película The Lion King. Es el padre de Simba', 'mufasa.jpg', 'Mufasa', '60.8');
INSERT INTO `api_disney`.`characters` (`id_character`, `age`, `history`, `image`, `name`, `weight`) VALUES ('4', '33', 'Ariel, es un personaje ficticio y el personaje protagonista de la película de animación', 'ariel.jpg', 'Ariel', '50');
INSERT INTO `api_disney`.`characters` (`id_character`, `age`, `history`, `image`, `name`, `weight`) VALUES ('5', '55', 'Úrsula es la villana de la película de Walt Disney, La sirenita', 'ursula.jpg', 'Ursula', '75');

INSERT INTO `api_disney`.`movie_character` (`movie_id`, `character_id`) VALUES ('1', '2');
INSERT INTO `api_disney`.`movie_character` (`movie_id`, `character_id`) VALUES ('1', '3');
INSERT INTO `api_disney`.`movie_character` (`movie_id`, `character_id`) VALUES ('2', '1');
INSERT INTO `api_disney`.`movie_character` (`movie_id`, `character_id`) VALUES ('3', '4');
INSERT INTO `api_disney`.`movie_character` (`movie_id`, `character_id`) VALUES ('3', '5');

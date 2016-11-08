package language.learning.convertor;

import language.learning.dto.LevelDTO;
import language.learning.model.Level;

public class LevelConvertor {
	public static Level convertToModel(LevelDTO levelDTO) {
		Level level = new Level();
		level.setLevelName(levelDTO.getLevelName());
		level.setIdLevel(levelDTO.getIdLevel());

		return level;
	}

	public static LevelDTO convertToDTO(Level level) {
		LevelDTO levelDTO = new LevelDTO();
		levelDTO.setLevelName(level.getLevelName());
		levelDTO.setIdLevel(levelDTO.getIdLevel());

		return levelDTO;
	}
}

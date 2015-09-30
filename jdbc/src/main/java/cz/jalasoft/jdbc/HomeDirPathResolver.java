package cz.jalasoft.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 9/30/15.
 */
final class HomeDirPathResolver {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeDirPathResolver.class);

    private static final String HOME_DIR_PATH_PREFIX = "~" + File.separator;

    String resolve(String path) {
        String pathAsString = path.toString();


        if (pathAsString.startsWith(HOME_DIR_PATH_PREFIX)) {
            String homeDir = System.getProperty("user.home") + File.separator;
            String resolvedPath = pathAsString.replace(HOME_DIR_PATH_PREFIX, homeDir);

            LOGGER.debug("Path to H2 database file has been resolved for home directory from '{}' to '{}'.", path, resolvedPath);
            return resolvedPath;
        }
        return path;
    }
}

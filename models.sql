
CREATE TABLE `patient` (
    `id` int(5) NOT NULL AUTO_INCREMENT,
    `medic_id` int(5) NOT NULL,
    `address_id` int(5) NOT NULL,
    `avatar_id` int(5) NOT NULL,
    `name` varchar(200) NOT NULL,
    `same` varchar(50) NOT NULL,
    `age` varchar(10) NOT NULL,
    `gender` smallint NOT NULL,
    `color` varchar(30) NOT NULL,
    `profession` varchar(255) NOT NULL,
    `born_city` varchar(255) NOT NULL,
    `phone` varchar(50) NOT NULL,
    `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `created_at` datetime NOT NULL,
    `active` tinyint(1) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `medic` (
    `id` int(5) NOT NULL AUTO_INCREMENT,
    `institution_id` int(5) NOT NULL,
    `address_id` int(5) NOT NULL,
    `avatar_id` int(5) NOT NULL,
    `name` varchar(256) NOT NULL,
    `phone` varchar(128) NOT NULL,
    `email` varchar(256) NOT NULL,
    `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `created_at` datetime NOT NULL,
    `active` tinyint(1) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `clinical_exam` (
    `id` int(5) NOT NULL AUTO_INCREMENT,
    `patient_id` int(5) NOT NULL,
    `bloating` tinyint(1) NOT NULL,
    `epigastric_pain` tinyint(1) NOT NULL,
    `slimming` tinyint(1) NOT NULL,
    `palpable_lymphonodes` varchar(255) NOT NULL,
    `anorexia` tinyint(1) NOT NULL,
    `gastrointestinal_bleeding` tinyint(1) NOT NULL,
    `palpable_mass` varchar(255) NOT NULL,
    `vomiting` tinyint(1) NOT NULL,
    `hepatomegaly` tinyint(1) NOT NULL,
    `rectal_examination` varchar(255) NOT NULL,
    `ascite` tinyint(1) NOT NULL,
    `anemia` tinyint(1) NOT NULL,
    `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `created_at` datetime NOT NULL,
    `active` tinyint(1) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `address` (
    `id` int(5) NOT NULL AUTO_INCREMENT,
    `country` varchar(255) NOT NULL,
    `uf` char(2) NOT NULL,
    `city` varchar(255) NOT NULL,
    `street` varchar(255) NOT NULL,
    `number` int(6) NOT NULL,
    `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `created_at` datetime NOT NULL,
    `active` tinyint(1) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `institution` (
    `id` int(5) NOT NULL AUTO_INCREMENT,
    `address_id` int(5) NOT NULL,
    `avatar_id` int(5) NOT NULL,
    `name` varchar(255) NOT NULL,
    `web_page` varchar(255) NOT NULL,
    `phone` varchar(15) NOT NULL,
    `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `created_at` datetime NOT NULL,
    `active` tinyint(1) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `diagnostic_exam` (
    `id` int(5) NOT NULL AUTO_INCREMENT,
    `patient_id` int(5) NOT NULL,
    `digestive_endoscopy` varchar(255) NOT NULL,
    `endoscopy_date` date NOT NULL,
    `lauren_classification` smallint NOT NULL,
    `biopsies_count` int(5) NOT NULL,
    `xray_EED` varchar(255) NOT NULL,
    `xray_date` date NOT NULL,
    `CA724` varchar(255) NOT NULL,
    `CEA` varchar(255) NOT NULL,
    `CA199` varchar(255) NOT NULL,
    `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `created_at` datetime NOT NULL,
    `active` tinyint(1) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `post_operatory_endoscopy` (
    `id` int(5) NOT NULL AUTO_INCREMENT,
    `patient_id` int(5) NOT NULL,
    `description` text NOT NULL,
    `date` date NOT NULL,
    `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `created_at` datetime NOT NULL,
    `active` tinyint(1) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `post_operatory_avaliation` (
    `id` int(5) NOT NULL AUTO_INCREMENT,
    `patient_id` int(5) NOT NULL,
    `number_of_meals` int(5) NOT NULL,
    `time_between_meals` smallint  NOT NULL,
    `consistency` smallint NOT NULL,
    `ingestion_capacity` smallint  NOT NULL,
    `appetite` smallint NOT NULL,
    `weight` smallint NOT NULL,
    `dysphagia` smallint NOT NULL,
    `pyrosis` smallint NOT NULL,
    `diarrhea` smallint NOT NULL,
    `abdominal_pain`smallint  NOT NULL,
    `vomit` smallint NOT NULL,
    `fulness` smallint  NOT NULL,
    `dumping` smallint  NOT NULL,
    `total_score` int(5)  NOT NULL,
    `comments` text  NOT NULL,
    `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `created_at` datetime NOT NULL,
    `active` tinyint(1) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `avatar` (
    `id` int(5) NOT NULL AUTO_INCREMENT,
    `image` LONGBLOB NOT NULL,
    `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `created_at` datetime NOT NULL,
    `active` tinyint(1) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

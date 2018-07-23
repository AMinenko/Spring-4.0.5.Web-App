CREATE TABLE `APPT_HEADER` (
`id` bigint(20),
`driverName` varchar(45),
`emailAddress` varchar(45),
`apptStart` timestamp,
`palletQty` long(45),
`apptCmplteTs` timestamp,
`apptCheckOutTs` timestamp,
`frontTemp` decimal(11),
`trailrMiddleTemp` decimal(11),
`trailrRearTemp` decimal(11),
`apptRefNumber` varchar(45),
`driverNumber` integer(45),
`trailerLoc` varchar(45),
`caseQty` long(45)
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
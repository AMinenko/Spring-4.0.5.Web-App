CREATE TABLE "APPT_HEADER" (
"id" BIGINT,
"driverName" VARCHAR(45),
"emailAddress" VARCHAR(45),
"apptStart" TIMESTAMP,
"palletQty" BIGINT,
"apptCmplteTs" TIMESTAMP,
"apptCheckOutTs" TIMESTAMP,
"frontTemp" DECIMAL(11),
"trailrMiddleTemp" DECIMAL(11),
"trailrRearTemp" DECIMAL(11),
"apptRefNumber" VARCHAR(45),
"driverNumber" BIGINT,
"trailerLoc" VARCHAR(45),
"caseQty" BIGINT,
PRIMARY KEY ("id")
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
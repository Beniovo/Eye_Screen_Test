BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "Questions" (
	"ID"	INTEGER NOT NULL UNIQUE,
	"Question"	INTEGER NOT NULL,
	"Answer"	INTEGER NOT NULL,
	"Type"	INTEGER NOT NULL,
	"Feedback"	INTEGER,
	"Option1"	INTEGER,
	"Option2"	INTEGER,
	"Option3"	INTEGER,
	"Option4"	INTEGER,
	"Option5"	INTEGER,
	"Option6"	INTEGER,
	"Option7"	INTEGER,
	"Option8"	INTEGER,
	"Option9"	INTEGER,
	PRIMARY KEY("ID" AUTOINCREMENT)
);
INSERT INTO "Questions" ("ID","Question","Answer","Type","Feedback","Option1","Option2","Option3","Option4","Option5","Option6","Option7","Option8","Option9") VALUES (1,'How old are you?','Less than 40 years old','Objective','From age 40, the majority of people start to experience Presbyopia which is a loss of focus at near. This makes focusing on near objects difficult leading to blur vision when trying to read or when doing other close up tasks. This is a natural and often annoying part of aging and signals the need for reading glasses. 

Also from age 40, your eyes are more at risk for certain eye conditions and this risk increases with age. Cataracts and Age-related macula degeneration are examples of some eye conditions whose risks increase with age.

','Less than 40 years old','40 years and over',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO "Questions" ("ID","Question","Answer","Type","Feedback","Option1","Option2","Option3","Option4","Option5","Option6","Option7","Option8","Option9") VALUES (2,'How long ago was your last eye test?','2 years ago or less.','Objective','It is recommended that you have an eye test at least
every two years. An eye test may be required more
frequently than every two years depending on your
unique circumstances such as age, your risk of
developing a serious eye condition, your health, your
family history and for certain other reasons.
Children may need to have their eyes tested more
frequently too. ','2 years ago or less.','More than 2 years ago.','Never had an eye test.',NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO "Questions" ("ID","Question","Answer","Type","Feedback","Option1","Option2","Option3","Option4","Option5","Option6","Option7","Option8","Option9") VALUES (3,'Do you have any of the following eye conditions?','None of the Above','Objective','If you have existing eye conditions like glaucoma, macula
degeneration, cataracts, diabetic retinopathy and the likes,
you need to ensure that you attend your regular physical eye
examination as it is important that you are regularly
examined by your optometrist or eye doctor.','Glaucoma','Macula Degeneration','Cataracts','Diabetic retinopathy','None of the Above',NULL,NULL,NULL,NULL);
INSERT INTO "Questions" ("ID","Question","Answer","Type","Feedback","Option1","Option2","Option3","Option4","Option5","Option6","Option7","Option8","Option9") VALUES (4,'Do you suffer from any of these health conditions?','None of the Above','Objective','If you suffer from the health conditions mentioned above or
some other chronic health condition, it is important that
these are properly controlled either by your prescribed
medication or other recommendation by your doctor. 
Most of these health conditions, if not properly controlled
can have adverse effect on the eyes and vision.','Diabetes','High blood pressure','High cholesterol','None of the Above',NULL,NULL,NULL,NULL,NULL);
INSERT INTO "Questions" ("ID","Question","Answer","Type","Feedback","Option1","Option2","Option3","Option4","Option5","Option6","Option7","Option8","Option9") VALUES (5,'Do you currently experience any of these?
','None of the above','Objective','If you experience frequent headaches OR double vision
OR pain in your eyes, it is advisable that you visit your
optometrist or eye doctor for a physical eye exam as
these symptoms could be a sign of more serious eye
issues.



It is also advisable to get any red eye checked out by
your optometrist or eye doctor.



If you experience dry, sore and watery eyes, you may be
suffering from dry eyes and can get an over the counter
eye lubricant from your pharmacist to help these
symptoms.



If you experience itchy and watery eyes, you may be
suffering from eye allergies or hay fever and can get an
over the counter anti-allergy eye drop from your
pharmacist to help these symptoms.

If you experience any of these symptoms including
others not listed here, then you need to speak with your
optometrist immediately.
','Frequent headaches','Red eyes','Sore eyes','Watery eyes','Double vision','Painful eyes','Dry eyes','Itchy eyes','None of the above');
INSERT INTO "Questions" ("ID","Question","Answer","Type","Feedback","Option1","Option2","Option3","Option4","Option5","Option6","Option7","Option8","Option9") VALUES (6,'Do you get blur vision at distance?

such as when driving or watching TV?
','No','Objective','This is good. However, if you do drive, make sure you can clearly read a number plate at 20 metres away. If you are unsure, visit your optometrist.

','Yes','No',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO "Questions" ("ID","Question","Answer","Type","Feedback","Option1","Option2","Option3","Option4","Option5","Option6","Option7","Option8","Option9") VALUES (7,'Do you get blur vision at near? Such as when reading or doing close up tasks?','No','Objective','This is good but if you get headaches or eyestrain when reading or doing close up tasks, it is advisable to have a physical eye exam to check this.

','Yes','No','',NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO "Questions" ("ID","Question","Answer","Type","Feedback","Option1","Option2","Option3","Option4","Option5","Option6","Option7","Option8","Option9") VALUES (8,'Which of these circles appears darker?

','Both circles are the same.','Objective','If the circles in the green or red background appear clearer, this indicates that you may have a refractive error and might need glasses to correct this. 

We advise you visit your optometrist or eye doctor to check this.

','The circles in the green background are darker.','The circles in the red background are darker.','Both circles are the same.',NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO "Questions" ("ID","Question","Answer","Type","Feedback","Option1","Option2","Option3","Option4","Option5","Option6","Option7","Option8","Option9") VALUES (9,'Which of these circles appears darker?

','Both circles are the same.','Objective','If the circles in the green or red background appear clearer, this indicates that you may have a refractive error and might need glasses to correct this. 

We advise you visit your optometrist or eye doctor to check this.

','The circles in the green background are darker.','The circles in the red background are darker.','Both circles are the same.',NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO "Questions" ("ID","Question","Answer","Type","Feedback","Option1","Option2","Option3","Option4","Option5","Option6","Option7","Option8","Option9") VALUES (10,'Which is the smallest line you can read clearly with your right eye?','Line 8 or Line 9 or Line 10 or Line 11','Objective','If you are unable to see Line 8 and below, this is a strong indication that your vision is less than is expected and you may need to have a physical eye examination for further investigation to determine if you have a refractive error or any other eye problems. We advise that you see your optometrist or eye doctor to check this.','Line 1 or Line 2','Line 3 or 4','Line 5 or Line 6 or Line 7','Line 8 or Line 9 or Line 10 or Line 11',NULL,NULL,NULL,NULL,NULL);
INSERT INTO "Questions" ("ID","Question","Answer","Type","Feedback","Option1","Option2","Option3","Option4","Option5","Option6","Option7","Option8","Option9") VALUES (11,'Which is the smallest line you can read clearly with your left eye?','Line 8 or Line 9 or line 10 or line 11','Objective','If you are unable to see Line 8 and below, this is a strong indication that your vision is less than is expected and you may need need to have a physical eye examination for further investigation to determine if you have a refractive error or any other eye problems. We advise that you see your optometrist or eye doctor to check this.','Line 1 or Line 2','Line 3 or Line 4','Line 5 or Line 6 or Line 7','Line 8 or Line 9 or line 10 or line 11',NULL,NULL,NULL,NULL,NULL);
INSERT INTO "Questions" ("ID","Question","Answer","Type","Feedback","Option1","Option2","Option3","Option4","Option5","Option6","Option7","Option8","Option9") VALUES (12,'Do you get flashes or floaters in your vision?

(flashes usually appear like small sparks of flashing lights at
the corner of your eye)

(floaters appear like small dark shadowy objects that move
across your vision when you move your eyes)','No, I don''t get flashes or floaters.','Objective','Flashes and floaters could be a sign of some more
serious eye condition especially when they occur
suddenly. 

If you suddenly experience flashes and floaters, please
see your optometrist or eye doctor immediately as you
would need to have a thorough examination of the
inside of your eyes.

Most times, floaters are usually experienced as part of
the ageing process and are benign. However if you
experience new floaters, it is advisable to have your
eyes examined as soon as possible.','Yes, I get flashes.','Yes, I get floaters.','Yes, I get both flashes and floaters.','No, I don''t get flashes or floaters.',NULL,NULL,NULL,NULL,NULL);
INSERT INTO "Questions" ("ID","Question","Answer","Type","Feedback","Option1","Option2","Option3","Option4","Option5","Option6","Option7","Option8","Option9") VALUES (13,'Which is the smallest line below that you can read clearly and comfortably without squinting?','Line 2 or Line 1','Objective','If you are finding it difficult to read small print close up and you are over age 40, you may have ''Presbyopia''. This is the inability of the eyes to focus near objects properly due to the loss of elasticity of the focusing lens in the eye. It is an age related condition.

If you are under age 40, you may be longsighted or have other focusing problems. 

In either case, you should visit your optometrist or eye doctor who may recommend some new glasses.','Line 4','Line 3','Line 2 or Line 1',NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO "Questions" ("ID","Question","Answer","Type","Feedback","Option1","Option2","Option3","Option4","Option5","Option6","Option7","Option8","Option9") VALUES (14,'Keep your eye focused on the black spot in the centre of the grid.

Do you notice any wobbling or distortion of the straight lines in the grid? Are there any missing lines or patches?
','No, the lines look straight; no distortion or missing lines.','Objective','Your response indicates you did not pass this macula screening question.

The macula is located in the retina at the back of the
eye. It is the area where you get your clearest central
vision and any problem with the macula such as macula
degeneration can result in loss of central vision.

If this is a new finding, you should visit your
optometrist/eye doctor as soon as possible to check this.','Yes, I can see some distortion.','Yes, I can see some missing lines/patches.','No, the lines look straight; no distortion or missing lines.',NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO "Questions" ("ID","Question","Answer","Type","Feedback","Option1","Option2","Option3","Option4","Option5","Option6","Option7","Option8","Option9") VALUES (15,'Keep your eye focused on the black spot in the centre of the grid.

Do you notice any wobbling or distortion of the straight lines in the grid? Are there any missing lines or patches?
','No, the lines look straight; no distortion or missing lines.','Objective','Your response indicates you did not pass this macula screening question.

The macula is located in the retina at the back of the
eye. It is the area where you get your clearest central
vision and any problem with the macula such as macula
degeneration can result in loss of central vision.

If this is a new finding, you should visit your
optometrist/eye doctor as soon as possible to check this.','Yes, I can see some distortion.','Yes, I can see some missing lines/patches.','No, the lines look straight; no distortion or missing lines.',NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO "Questions" ("ID","Question","Answer","Type","Feedback","Option1","Option2","Option3","Option4","Option5","Option6","Option7","Option8","Option9") VALUES (16,'Do any of the lines in any of the segments 1 2 3 4 5 6 7 appear darker or sharper than the others?
','No','Objective','You did not pass this question for Astigmatism.

Astigmatism is an eye condition where your eye is
shaped more like a rugby ball than a football which
causes light to focus at different points in the eye rather
than one fixed point. This could lead to blur vision and
eye strain.

We strongly advice you should visit your optometrist or
eye doctor to check this out. 

','Yes','No',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO "Questions" ("ID","Question","Answer","Type","Feedback","Option1","Option2","Option3","Option4","Option5","Option6","Option7","Option8","Option9") VALUES (17,'Do any of the lines in any of the segments 1 2 3 4 5 6 7 appear darker or sharper than the others?
','No','Objective','You did not pass this question for Astigmatism.

Astigmatism is an eye condition where your eye is
shaped more like a rugby ball than a football which
causes light to focus at different points in the eye rather
than one fixed point. This could lead to blur vision and
eye strain.

We strongly advice you should visit your optometrist or
eye doctor to check this out. 

','Yes','No',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO "Questions" ("ID","Question","Answer","Type","Feedback","Option1","Option2","Option3","Option4","Option5","Option6","Option7","Option8","Option9") VALUES (18,'What number do you see in the plate? 



If you do not see a number, then put X as the answer.',12,'G.Obj','Well done, you passed this plate in the colour vision quiz. Everyone is expected  to pass this plate whether they have a colour vision defect or not.',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO "Questions" ("ID","Question","Answer","Type","Feedback","Option1","Option2","Option3","Option4","Option5","Option6","Option7","Option8","Option9") VALUES (19,'What number do you see in the plate? 



If you do not see a number, then put X as the answer.',29,'G.Obj','Well done, you passed this plate in the colour vision quiz. 

We advise you see your optometrist to confirm this.',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO "Questions" ("ID","Question","Answer","Type","Feedback","Option1","Option2","Option3","Option4","Option5","Option6","Option7","Option8","Option9") VALUES (20,'What number do you see in the plate? 



If you do not see a number, then put X as the answer.',15,'G.Obj','Well done, you passed this plate in the colour vision quiz. 

We advise you see your optometrist to confirm this.',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO "Questions" ("ID","Question","Answer","Type","Feedback","Option1","Option2","Option3","Option4","Option5","Option6","Option7","Option8","Option9") VALUES (21,'What number do you see in the plate? 



If you do not see a number, then put X as the answer.',97,'G.Obj','Well done, you passed this plate in the colour vision quiz. 

We advise you see your optometrist to confirm this.',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO "Questions" ("ID","Question","Answer","Type","Feedback","Option1","Option2","Option3","Option4","Option5","Option6","Option7","Option8","Option9") VALUES (22,'What number do you see in the plate? 



If you do not see a number, then put X as the answer.',16,'G.Obj','Well done, you passed this plate in the colour vision quiz. 

We advise you see your optometrist to confirm this.',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO "Questions" ("ID","Question","Answer","Type","Feedback","Option1","Option2","Option3","Option4","Option5","Option6","Option7","Option8","Option9") VALUES (23,'What number do you see in the plate? 



If you do not see a number, then put X as the answer.','x','G.Obj','Well done, you passed this plate in the colour vision quiz.

If you passed all six plates it suggests you might have
good colour vision.

We advise you visit your optometrist or eye doctor to
confirm this.

',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
COMMIT;

CREATE TABLE readings (
        reading_id SERIAL NOT NULL,
        reading VARCHAR(1000) NOT NULL,
        hexagram TEXT[]
);
	
CREATE TABLE fortunes (
        fortune_id SERIAL NOT NULL,
        question_date DATE NOT NULL,
        question VARCHAR(1000) NOT NULL,
        reading VARCHAR (1000)
);

INSERT INTO readings (reading, hexagram) VALUES ('Qian (The Creative) Life shows its harmony when you discover your connection to what unfolds.',
        '{ getLine2(), getLine2(), getLine2(), getLine2(), getLine2(), getLine2() }');
INSERT INTO readings (reading, hexagram) VALUES	('Kun (The Receptive) Reaction is how you defend the past against the future.',
	'{ getLine1(), getLine1(), getLine1(), getLine1(), getLine1(), getLine1() }');
INSERT INTO readings (reading, hexagram) VALUES	('Zhun (Difficult Beginnings) Dragging the adversary about when there is no adversary will cost you your inner treasure.',
	'{ getLine2(), getLine1(), getLine1(), getLine1(), getLine2(), getLine1() }');
INSERT INTO readings (reading, hexagram) VALUES	('Meng (Youthful Folly) To know success you must make peace with the idea of failing.',
	'{ getLine1(), getLine2(), getLine1(), getLine1(), getLine1(), getLine2() }');
INSERT INTO readings (reading, hexagram) VALUES	('Xu (Nourished While Waiting) Failure and success come to test the depth and nature of your sincerity.',
	'{ getLine2(), getLine2(), getLine2(), getLine1(), getLine2(), getLine1() }');
INSERT INTO readings (reading, hexagram) VALUES	('Song (Conflict) When you open all obstacles will disappear.',
	'{ getLine1(), getLine2(), getLine1(), getLine2(), getLine2(), getLine2() }');
INSERT INTO readings (reading, hexagram) VALUES	('Shi (Army) To know fulfillment nourish what is for the belly and not the eye.',
	'{ getLine1(), getLine2(), getLine1(), getLine1(), getLine1(), getLine1() }');
INSERT INTO readings (reading, hexagram) VALUES	('Bi (Uniting) When you merge the world in here with the world out there your destiny is revealed.',
	'{ getLine1(), getLine1(), getLine1(), getLine1(), getLine2(), getLine1() }');
INSERT INTO readings (reading, hexagram) VALUES	('Xiao Chu (Small Restraint) There is no real blockage that can withstand submission.',
	'{ getLine2(), getLine2(), getLine2(), getLine1(), getLine2(), getLine2() }');
INSERT INTO readings (reading, hexagram) VALUES	('Lu (Treading) Participate with life do not mystify it.',
	'{ getLine2(), getLine2(), getLine1(), getLine2(), getLine2(), getLine2() }');
INSERT INTO readings (reading, hexagram) VALUES	('Tai (Peace) Being free of desires you will discover that the empire is at peace of its own accord.',
	'{ getLine2(), getLine2(), getLine2(), getLine1(), getLine1(), getLine1() }');
INSERT INTO readings (reading, hexagram) VALUES	('Pi (Standstill) Contentment cannot be held in the hand but lives perpetually in the heart.',
	'{ getLine1(), getLine1(), getLine1(), getLine2(), getLine2(), getLine2() }');
INSERT INTO readings (reading, hexagram) VALUES	('Tong Ren (Fellowship) If you understand natures symmetries you will use no counting rods.',
	'{ getLine2(), getLine1(), getLine2(), getLine2(), getLine2(), getLine2() }');
INSERT INTO readings (reading, hexagram) VALUES	('Da You (Great Possessing) If you are not playing the host you will discover that you are the guest.',
	'{ getLine2(), getLine2(), getLine2(), getLine2(), getLine1(), getLine2() }');
INSERT INTO readings (reading, hexagram) VALUES	('Qian (Authenticity) If you know no boundaries you will discover no limitations.',
	'{ getLine1(), getLine1(), getLine2(), getLine1(), getLine1(), getLine1() }');
INSERT INTO readings (reading, hexagram) VALUES	('Yu (Enthusiasm) If you make your home in the inevitable you will arrive exactly where you need to be.',
	'{ getLine1(), getLine1(), getLine1(), getLine2(), getLine1(), getLine1() }');
INSERT INTO readings (reading, hexagram) VALUES	('Sui (Following) If you return from the darkness with gold others will naturally follow.',
	'{ getLine2(), getLine1(), getLine1(), getLine2(), getLine2(), getLine1() }');
INSERT INTO readings (reading, hexagram) VALUES	('Gu (Decay) All things are supple when alive but become hard when dead.',
	'{ getLine1(), getLine2(), getLine2(), getLine1(), getLine1(), getLine2() }');
INSERT INTO readings (reading, hexagram) VALUES	('Lin (Approach) When you place yourself in a position to help another you will discover your greater capabilities.',
	'{ getLine2(), getLine2(), getLine1(), getLine1(), getLine1(), getLine1() }');
INSERT INTO readings (reading, hexagram) VALUES	('Guan (Contemplation) You can only lead others toward growth if you are willing to grow yourself.',
	'{ getLine1(), getLine1(), getLine1(), getLine1(), getLine2(), getLine2() }');
INSERT INTO readings (reading, hexagram) VALUES	('Shi Ke (Gnawing Bite) To keep others down you would have to live your life on your knees.',
	'{ getLine2(), getLine1(), getLine1(), getLine2(), getLine1(), getLine2() }');
INSERT INTO readings (reading, hexagram) VALUES	('Bi (Grace) When you lose your way life always hands you a map that says you are here.',
	'{ getLine2(), getLine1(), getLine2(), getLine1(), getLine1(), getLine2() }');
INSERT INTO readings (reading, hexagram) VALUES	('Bo (Split Apart) All of life will not change you it unfolds as a way to unmask you.',
	'{ getLine1(), getLine1(), getLine1(), getLine1(), getLine1(), getLine2() }');
INSERT INTO readings (reading, hexagram) VALUES	('Fu (Return) Progress is often marked by a slow return to original sincerity.',
	'{ getLine2(), getLine1(), getLine1(), getLine1(), getLine1(), getLine1() }');
INSERT INTO readings (reading, hexagram) VALUES	('Wu Wang (Innocence) If you don t know what cannot be done  you will accomplish great things.',
	'{ getLine2(), getLine1(), getLine1(), getLine2(), getLine2(), getLine2() }');
INSERT INTO readings (reading, hexagram) VALUES	('Da Chu (Controlled Power) Your vital force is not wanting only waiting for you to tap it.',
	'{ getLine2(), getLine2(), getLine2(), getLine1(), getLine1(), getLine2() }');
INSERT INTO readings (reading, hexagram) VALUES	('Yi (Nourishing Vision) Ignorance is the night of the mind but a night without moon and star.',
	'{ getLine2(), getLine1(), getLine1(), getLine1(), getLine1(), getLine2() }');
INSERT INTO readings (reading, hexagram) VALUES	('Da Guo (Critical Mass) To follow the energy of life you will discover that it is always seeking the best of what you might become.',
	'{ getLine1(), getLine2(), getLine2(), getLine2(), getLine2(), getLine1() }');
INSERT INTO readings (reading, hexagram) VALUES	('Kan (Abyss) If you cannot change the direction of the wind adjust your sails and let it guide you.',
	'{ getLine1(), getLine2(), getLine1(), getLine1(), getLine2(), getLine1() }');
INSERT INTO readings (reading, hexagram) VALUES	('Li (Clarity) When you can appreciate natures power to break through all barriers you will discover that this same power is inside of you.',
	'{ getLine2(), getLine1(), getLine2(), getLine2(), getLine1(), getLine2() }');
INSERT INTO readings (reading, hexagram) VALUES	('Xian (Influence/Wooing) Wooing is how you attract those things that you desire.',
	'{ getLine1(), getLine1(), getLine2(), getLine2(), getLine2(), getLine1() }');
INSERT INTO readings (reading, hexagram) VALUES	('Heng (Duration) Commitment is the force of attraction that brings all things back to you.',
	'{ getLine1(), getLine2(), getLine2(), getLine2(), getLine1(), getLine1() }');
INSERT INTO readings (reading, hexagram) VALUES	('Dun (Retreat) Content in your power you have no need to engage the obstacle.',
	'{ getLine1(), getLine1(), getLine2(), getLine2(), getLine2(), getLine2() }');
INSERT INTO readings (reading, hexagram) VALUES	('Da Zhuang (Great Power) When you are steadfast in your power you cannot be thrown from your center.',
	'{ getLine2(), getLine2(), getLine2(), getLine2(), getLine1(), getLine1() }');
INSERT INTO readings (reading, hexagram) VALUES	('Jin (Progress) A foundation without prejudice is the first step in how the weak progresses.',
	'{ getLine1(), getLine1(), getLine1(), getLine2(), getLine1(), getLine2() }');
INSERT INTO readings (reading, hexagram) VALUES	('Ming Yi (Brightness Hiding) When the world grows dark your inner light is given definition.',
	'{ getLine2(), getLine1(), getLine2(), getLine1(), getLine1(), getLine1() }');
INSERT INTO readings (reading, hexagram) VALUES	('Jia Ren (Family) In the contrast of the family life reveals your deeper color.',
	'{ getLine2(), getLine1(), getLine2(), getLine1(), getLine2(), getLine2() }');
INSERT INTO readings (reading, hexagram) VALUES	('Kui (Opposition) Lifes natural friction is the force that shapes your individuality.',
	'{ getLine2(), getLine2(), getLine1(), getLine2(), getLine1(), getLine2() }');
INSERT INTO readings (reading, hexagram) VALUES	('Jian (Obstruction) Adversity is how life unleashes your excellence from within.',
	'{ getLine1(), getLine1(), getLine2(), getLine1(), getLine2(), getLine1() }');
INSERT INTO readings (reading, hexagram) VALUES	('Xie (Liberation) There is no real difficulty that requires outward movement.',
	'{ getLine1(), getLine2(), getLine1(), getLine2(), getLine1(), getLine1() }');
INSERT INTO readings (reading, hexagram) VALUES	('Sun (Decrease) What is unobservable in this world is gestating in unseen form.',
	'{ getLine2(), getLine2(), getLine1(), getLine1(), getLine1(), getLine2() }');
INSERT INTO readings (reading, hexagram) VALUES	('Yi (Increase) The law of compensation shows how what is springs from what is not.',
	'{ getLine2(), getLine1(), getLine1(), getLine1(), getLine2(), getLine2() }');
INSERT INTO readings (reading, hexagram) VALUES	('Guai (Determination) Success comes when you untangle the knots and soften the glare.',
	'{ getLine2(), getLine2(), getLine2(), getLine2(), getLine2(), getLine1() }');
INSERT INTO readings (reading, hexagram) VALUES	('Gou (Coming to meet) Hope is like a flower forced to grow without sunlight.',
	'{ getLine1(), getLine2(), getLine2(), getLine2(), getLine2(), getLine2() }');
INSERT INTO readings (reading, hexagram) VALUES	('Cui (Gathering Together) Success is allowing your lot to reach its highest degree.',
	'{ getLine1(), getLine1(), getLine1(), getLine2(), getLine2(), getLine1() }');
INSERT INTO readings (reading, hexagram) VALUES	('Sheng (Pushing Upward) When you pay respect to the great you pave the way for your own greatness.',
	'{ getLine1(), getLine2(), getLine2(), getLine1(), getLine1(), getLine1() }');
INSERT INTO readings (reading, hexagram) VALUES	('Kun (Oppression/Exhaustion) Success is a pathway of self-completion and the seed is always within you.',
	'{ getLine1(), getLine2(), getLine1(), getLine2(), getLine2(), getLine1() }');
INSERT INTO readings (reading, hexagram) VALUES	('Jing (The Well) You can spend a lifetime and still never come anywhere close to exhausting the resources that are inside of you.',
	'{ getLine1(), getLine2(), getLine2(), getLine1(), getLine2(), getLine1() }');
INSERT INTO readings (reading, hexagram) VALUES	('Ge (Molting/Revolution) Unhappiness is the first sign that something powerful stirs within you.',
	'{ getLine2(), getLine1(), getLine2(), getLine2(), getLine2(), getLine1() }');
INSERT INTO readings (reading, hexagram) VALUES	('Ding (Cauldron) You hold the power to become the master of your existence.',
	'{ getLine1(), getLine2(), getLine2(), getLine2(), getLine1(), getLine2() }');
INSERT INTO readings (reading, hexagram) VALUES	('Zhen (Shocking) Success comes when you achieve tranquility in disturbance.',
	'{ getLine2(), getLine1(), getLine1(), getLine2(), getLine1(), getLine1() }');
INSERT INTO readings (reading, hexagram) VALUES	('Gen (Keeping Still) You will discover the germinating power within in the silence where a thousand seeds are becoming the landscape of spring.',
	'{ getLine1(), getLine1(), getLine2(), getLine1(), getLine1(), getLine2() }');
INSERT INTO readings (reading, hexagram) VALUES	('Jian (Development) Success comes when you pull your nature forward without pushing yourself into the world.',
	'{ getLine1(), getLine1(), getLine2(), getLine1(), getLine2(), getLine2() }');
INSERT INTO readings (reading, hexagram) VALUES	('Gui Mei (Propiety) Instinct is the bubbling of Te excited by the prospect of your coming-to-be-real.',
	'{ getLine2(), getLine2(), getLine1(), getLine2(), getLine1(), getLine1() }');
INSERT INTO readings (reading, hexagram) VALUES	('Feng (Abundance) If you make your heart like a lake life will continuously fulfill you.',
	'{ getLine2(), getLine1(), getLine2(), getLine2(), getLine1(), getLine1() }');
INSERT INTO readings (reading, hexagram) VALUES	('Lu (The Wanderer) And the still deeper secret of the secret: the land that is nowhere that is your true home.',
	'{ getLine1(), getLine1(), getLine2(), getLine2(), getLine1(), getLine2() }');
INSERT INTO readings (reading, hexagram) VALUES	('Xun (Penetration) Something very profound is also committed to your success.',
	'{ getLine1(), getLine2(), getLine2(), getLine1(), getLine2(), getLine2() }');
INSERT INTO readings (reading, hexagram) VALUES	('Dui (Joy) Take aim at your heart and release your passion.',
	'{ getLine2(), getLine2(), getLine1(), getLine2(), getLine2(), getLine1() }');
INSERT INTO readings (reading, hexagram) VALUES	('Huan (Dispersion) There is a thing confusedly formed life is an all or nothing equation.',
	'{ getLine1(), getLine2(), getLine1(), getLine1(), getLine2(), getLine2() }');
INSERT INTO readings (reading, hexagram) VALUES	('Jie (Limitation) Adaptation leads you to harmonize with the changes. Everything you will ever need can be found within.',
	'{ getLine2(), getLine2(), getLine1(), getLine1(), getLine2(), getLine1() }');
INSERT INTO readings (reading, hexagram) VALUES	('Zhong Fu (Inner Truth) Do not seek to follow in the footsteps of the wise seek what they sought.',
	'{ getLine2(), getLine2(), getLine1(), getLine1(), getLine2(), getLine2() }');
INSERT INTO readings (reading, hexagram) VALUES	('Xiao Guo (Small Exceeding) The weak force is more powerful than gravity and the smallest of life forms are the most successful. Appreciating what is small is called enlightenment.',
	'{ getLine1(), getLine1(), getLine2(), getLine2(), getLine1(), getLine1() }');
INSERT INTO readings (reading, hexagram) VALUES	('Ji Ji (After Completion) Equilibrium is the great foundation of life and harmony its universal path.',
	'{ getLine2(), getLine1(), getLine2(), getLine1(), getLine2(), getLine1() }');
INSERT INTO readings (reading, hexagram) VALUES ('Wei Ji (Before Completion) You are always on the threshold of change how you approach it will determine your success.',
	'{ getLine1(), getLine2(), getLine1(), getLine2(), getLine1(), getLine2() }');		


ALTER TABLE readings ADD CONSTRAINT pk_readings PRIMARY KEY (reading_id);

ALTER TABLE fortunes ADD CONSTRAINT pk_fortunes PRIMARY KEY (fortune_id);

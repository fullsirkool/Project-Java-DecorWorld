--DROP DATABASE DecorWorld
--CREATE DATABASE DecorWorld
USE DecorWorld
GO
/****** Object:  Table [dbo].[Account]    Script Date: 9/14/2020 5:12:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[userID] [int] PRIMARY KEY IDENTITY(1,1) NOT NULL,
	[email] [nvarchar](50) NOT NULL,
	[password] [nvarchar](50) NOT NULL,
	[userName] [nvarchar](50) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[role] [int] NOT NULL,
	[address] [nvarchar](max) NOT NULL,
	[phoneNumber] [nvarchar](50) NOT NULL
) ON [PRIMARY] 
GO
SET IDENTITY_INSERT [dbo].[Account] ON 
/****** Object:  Table [dbo].[Brand]    Script Date: 9/14/2020 5:12:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Brand](
	[brandID] [int] PRIMARY KEY IDENTITY(1,1) NOT NULL,
	[brandName] [nvarchar](50) NOT NULL,
	[userID] INT FOREIGN KEY REFERENCES [Account]([userID])
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Categories]    Script Date: 9/14/2020 5:12:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Categories](
	[categoriesID] INT PRIMARY KEY IDENTITY(1,1) NOT NULL,
	[categoriesName] [nvarchar](50) NULL,
	[categoriesImg] [nvarchar] (max)NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Product]    Script Date: 9/14/2020 5:12:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[productID] [int] PRIMARY KEY IDENTITY(1,1) NOT NULL,
	[title] [nvarchar](max) NULL,
	[categoriesID] INT FOREIGN KEY REFERENCES [Categories]([categoriesID]) NOT NULL,
	[price] [money] NULL,
	[description] [nvarchar](max) NULL,
	[shortDescription] [nvarchar](max) NULL,
	[image] [nvarchar](max) NULL,
	[quantity][int] NULL,
	[brandID] INT FOREIGN KEY REFERENCES [Brand]([brandID]) NOT NULL,
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Evaluate]    Script Date: 10/17/2020 5:12:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Evaluate](
	[evaluateID] INT PRIMARY KEY IDENTITY(1,1) NOT NULL,
	[evaluateContent] [nvarchar](50) NULL,
	[rate][int] NOT NULL,
	[date][date] NOT NULL,
	[userID] INT FOREIGN KEY REFERENCES [Account]([userID]) NOT NULL,
	[productID] INT FOREIGN KEY REFERENCES [Product]([productID]) NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Cart]    Script Date: 9/14/2020 5:12:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cart](
	[userid] INT FOREIGN KEY REFERENCES [Account]([userID]),
	[productid] INT FOREIGN KEY REFERENCES [Product]([productID]),
	[quantity] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Bill]    Script Date: 9/14/2020 5:12:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Bill](
	[BillID] [nvarchar](50) NOT NULL,
	[userName] [nvarchar](50) NOT NULL,
	[address] [nvarchar](50) NOT NULL,
	[phoneNumber] [nvarchar](50) NOT NULL,
	[email][nvarchar](50) NOT NULL,
	[date] [date] NOT NULL,
	[userid] INT FOREIGN KEY REFERENCES [Account]([userID]) NUll,
	[productid] INT FOREIGN KEY REFERENCES [Product]([productID]),
	[quantity][int] NOT NULL,
	[status][int]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Cart]    Script Date: 11/08/2020 5:12:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Request](
	[userid] INT FOREIGN KEY REFERENCES [Account]([userID]),
	[content] [nvarchar](50) NOT NULL,
	[date][date]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Account] ON
SET IDENTITY_INSERT [dbo].[Account] OFF

/* Update quantity of product after buy */
GO
create TRIGGER trg_Order ON Bill FOR INSERT AS 
BEGIN
	UPDATE [Product]
	SET Product.quantity = Product.quantity - (SELECT quantity FROM inserted WHERE productid = Product.productID)
	FROM Product 
	JOIN inserted ON Product.productID = inserted.productid
END

GO

CREATE TRIGGER trg_CancelOrder on [dbo].[Bill] AFTER UPDATE AS
DECLARE @quantity INT
IF UPDATE([status])
BEGIN
	SELECT @quantity = b.quantity from Bill b, deleted d, inserted i
	WHERE b.productid = i.productid and b.productid = d.productid
END

BEGIN
   UPDATE [Product]
	SET Product.quantity = Product.quantity + @quantity
	FROM Product 
	JOIN inserted ON Product.productID = inserted.productid
end
GO

--Categories
insert into Categories values('Convenience Item','convenience.jpg')
insert into Categories values('Carpet','carpet.jpg')
insert into Categories values('Statue','statue.jpg')
insert into Categories values('Clock','clock.jpg')
insert into Categories values('Wall Decorate','wallDecor.jpg')
insert into Categories values('Table Decorate','tableDecor.jpg')
insert into Categories values('Model - Figure','figure.png')
insert into Categories values('Blanket, Curtain, Pillows','blanket.jpg')
insert into Categories values('Home Accessories','homeAc.jpg')

--Account
insert into Account values('decorworld@gmail.com','21232f297a57a5a743894a0e4a801fc3','admin','admin','1','Hoa Lac Hi-Tech Park - Thach Hoa, Thach That, Ha Noi','+84 96.188.888')
insert into Account values('testaccount@gmail.com','202cb962ac59075b964b07152d234b70','testaccount','testaccount','2','Ha Noi','094567634')
insert into Account values('huytran@c113.com','202cb962ac59075b964b07152d234b70','huytran','Huy Tran','2','Nam Dinh','0817382228')
insert into Account values('quangduy@c113.com','202cb962ac59075b964b07152d234b70','quangduy','Quang Duy','2','Ha Noi','0966419062')
insert into Account values('viethung@c113.com','202cb962ac59075b964b07152d234b70','viethung','Viet Hung','2','Hung Yen','0849682229')
insert into Account values('huyhoang@c113.com','202cb962ac59075b964b07152d234b70','huyhoang','Huy Hoang','2','Phu Tho','0977791094')
insert into Account values('beduc@c113.com','202cb962ac59075b964b07152d234b70','beduc','Be Duc','2','Nghe An','0987847641')

insert into Brand values('testaccount','2')
insert into Brand values('Huy Tran','3')
insert into Brand values('Quang Duy','4')
insert into Brand values('Viet Hung','5')
insert into Brand values('Huy Hoang','6')
insert into Brand values('Be Duc','7')

--Product

--Convenient Item
insert into Product values('Small Size Travel Cosmetic Bag', '1', '80000', 'One of the “must have” items when traveling, not to mention Travel cosmetic bag, is the savior for all girls.
Absolutely waterproof
- Spacious interior design
Handy dividing compartment
- Can be hung up when using
- Fashionable design', 'MUST HAVE WHEN TOURISM', 'CVItem1.jpg','150', '3')
insert into Product values('Travel Cosmetic Bag Middle Size', '1', '120000', 'One of the “must have” items when traveling, not to mention Travel cosmetic bag, is the savior for all girls.
Absolutely waterproof.
Spacious interior design.
Handy dividing compartment.
Can be hung up when using.
Fashionable design.', 'MUST HAVE WHEN TOURISM', 'CVItem3.jpg','220', '3')
insert into Product values('Japanese Style Storage Crate', '1', '220000', 'Convenient handle design helps you to move the crate easily. Harmonious colors in different vintage style, express your personality and contribute to adorn the living space more impressive and new. The sophisticated and meticulous machining technique produces a product that is not only good in quality but also in appearance.
- Raw advanced plastic fibers, environmentally friendly, 
- You can use it in the family, hotels, workplaces ...', 'Convenient handle design helps you to move the crate easily', 'CVItem3.jpg','50', '3')
insert into Product values('Cosmetic Shelves', '1', '400000', 'The 4-storey and 3-storey luxury cosmetic shelf is made of high-quality monolithic plastic, with multi-compartment design that will help you to preserve all kinds of beauty tools, cosmetics or jewelry items. be neat.Also you can use the tray containing makeup tools, cosmetics to store other items. Specially designed will help you find items easier and faster when needed.3 floors with size 34x25x29cm.', '3 floors with size 34x25x29cm','CVItem4.jpg','60', '4')

--Carpet
insert into Product values('Sofa Carpet DS001', '2', '300000', ' High-class sofa mat, imported products with quality and safe for your family health.
The mat is smooth, has anti-slip back friction, good waterproof. Can be cleaned with a vacuum cleaner or washing.
Application: living room, bedroom, reading area, relaxation
Material: felt
Size: 50x80cm, 60x90xm, 80x100xm, 120x160cm, 140x200cm', 'High-class sofa mat', 'Carpet1.jpg','50', '5')

insert into Product values('Sofa Carpet DS002', '2', '300000', ' High-class sofa mat, imported products with quality and safe for your family health.
The mat is smooth, has anti-slip back friction, good waterproof. Can be cleaned with a vacuum cleaner or washing.
Application: living room, bedroom, reading area, relaxation
Material: felt
Size: 50x80cm, 60x90xm, 80x100xm, 120x160cm, 140x200cm', 'High-class sofa mat', 'Carpet2.jpg','50', '5')

insert into Product values('Sofa Carpet DS003', '2', '300000', ' High-class sofa mat, imported products with quality and safe for your family health.
The mat is smooth, has anti-slip back friction, good waterproof. Can be cleaned with a vacuum cleaner or washing.
Application: living room, bedroom, reading area, relaxation
Material: felt
Size: 50x80cm, 60x90xm, 80x100xm, 120x160cm, 140x200cm', 'High-class sofa mat', 'Carpet3.jpg','50', '5')

insert into Product values('Sofa Carpet DS004', '2', '300000', ' High-class sofa mat, imported products with quality and safe for your family health.
The mat is smooth, has anti-slip back friction, good waterproof. Can be cleaned with a vacuum cleaner or washing.
Application: living room, bedroom, reading area, relaxation
Material: felt
Size: 50x80cm, 60x90xm, 80x100xm, 120x160cm, 140x200cm', 'High-class sofa mat', 'Carpet4.jpg','50', '5')

--Statute
insert into Product values('Green Horse', '3', '650000', 'The warrior horse statue shows strength and certainty. With sophisticated design, suitable for many display spaces such as living room, office, reading room ... with modern but no less artistic', 'The warrior horse statue shows strength and certainty', 'statute1.jpg','20', '4')
insert into Product values('Horse', '3', '650000', 'The warrior horse statue shows strength and certainty. With sophisticated design, suitable for many display spaces such as living room, office, reading room ... with modern but no less artistic', 'The warrior horse statue shows strength and certainty', 'statute2.jpg','20', '4')
insert into Product values('Street Musicians', '3', '700000', 'Three Street Musicians', 'Three Street Musicians', 'statute3.jpg','10', '4')
insert into Product values('Swans', '3', '700000', '', '', 'statute4.jpg','10', '4')
insert into Product values('Decorative Deer', '3', '600000', 'Specifications: Size: 20 * 18 * 42cm Material: Synthetic plastic Packing: Foam box Suitable as gifts - living room decoration - office work.', 'Specifications: Size: 20 * 18 * 42cm Material: Synthetic plastic Packing: Foam box Suitable as gifts - living room decoration - office work.', 'statute5.jpg','10', '4')
insert into Product values('Whisper', '3', '700000', '', '', 'statute6.jpg','10', '4')

--Clock
insert into Product values('Clock DSC001', '4', '650000', 'GeekCook watches  are  luxurious, sophisticated and classy in every line. Products used to hang living room, common room, reading room or as a housewarming gift are very practical and valuable.', 'Luxurious Wall Clock', 'Clock1.jpg','10', '5')
insert into Product values('Clock DSC002', '4', '650000', 'GeekCook watches  are  luxurious, sophisticated and classy in every line. Products used to hang living room, common room, reading room or as a housewarming gift are very practical and valuable.', 'Luxurious Wall Clock', 'Clock2.jpg','10', '5')
insert into Product values('Clock DSC003', '4', '650000', 'GeekCook watches  are  luxurious, sophisticated and classy in every line. Products used to hang living room, common room, reading room or as a housewarming gift are very practical and valuable.', 'Luxurious Wall Clock', 'Clock3.jpg','10', '5')
insert into Product values('Clock DSC004', '4', '650000', 'GeekCook watches  are  luxurious, sophisticated and classy in every line. Products used to hang living room, common room, reading room or as a housewarming gift are very practical and valuable.', 'Luxurious Wall Clock', 'Clock4.jpg','10', '5')
insert into Product values('Clock DSC005', '4', '650000', 'GeekCook watches  are  luxurious, sophisticated and classy in every line. Products used to hang living room, common room, reading room or as a housewarming gift are very practical and valuable.', 'Luxurious Wall Clock', 'Clock5.jpg','10', '5')
insert into Product values('Clock DSC006', '4', '650000', 'GeekCook watches  are  luxurious, sophisticated and classy in every line. Products used to hang living room, common room, reading room or as a housewarming gift are very practical and valuable.', 'Luxurious Wall Clock', 'Clock6.jpg','10', '5')
insert into Product values('Clock DSC007', '4', '650000', 'GeekCook watches  are  luxurious, sophisticated and classy in every line. Products used to hang living room, common room, reading room or as a housewarming gift are very practical and valuable.', 'Luxurious Wall Clock', 'Clock7.png','10', '5')

--Wall Decorate
insert into Product values('Mystery Giraffe', '5', '1000000', 'Painting is digitally printed on canvas background with sharp, professional framing technique. This picture set comes packed with 3-pin nail, easy to hang on the wall.', 'Mystery Giraffe Canvat', 'wallDecor1.jpg','20', '3')
insert into Product values('Summer Bohemian painting set', '5', '1000000', 'Painting is digitally printed on canvas background with sharp, professional framing technique. This picture set comes packed with 3-pin nail, easy to hang on the wall.', 'Summer Bohemian painting set Canvat', 'wallDecor2.jpg','20', '3')
insert into Product values('Flower', '5', '1000000', 'Painting is digitally printed on canvas background with sharp, professional framing technique. This picture set comes packed with 3-pin nail, easy to hang on the wall.', 'Lotus Canvat', 'wallDecor3.jpg','20', '3')
insert into Product values('Lotus', '5', '1000000', 'Painting is digitally printed on canvas background with sharp, professional framing technique. This picture set comes packed with 3-pin nail, easy to hang on the wall.', 'Flower Canvat', 'wallDecor4.jpg','20', '3')
insert into Product values('Leaves, Tropical collection', '5', '1000000', 'Painting is digitally printed on canvas background with sharp, professional framing technique. This picture set comes packed with 3-pin nail, easy to hang on the wall.', 'Leaves, Tropical collection Canvat', 'wallDecor5.jpg','20', '3')

--Table Decorate
insert into Product values('SMART LED WOODEN WATCH FOR WHITE BLACK LED FRAME', '6', '270000', 'Material: Wood and Plastic.
Display time and temperature at the same time.
Can choose between Celsius and Fahrenheit.
Power supply: 4 AAA batteries or 5V USB adapter.
Size: 15 x 7 x 5 (cm).
Weight: 300 (g).
Products include: 01 clock, 01 USB power cord and user manual.
Display time (12h or 24h), day, month, year.
Sensor brightness according to the surrounding environment.
Alarm 3 times a day.
Electronic thermometer.
Sound sensor technology.
Clear digits with LED technology.
Price: 270K - Free Shipping Nationwide.
Warranty: 6 Months Genuine.', '', 'tableDecor1.jpg','70', '5')
insert into Product values('SMART LED WOODEN WATCH FOR WHITE LED BRACKET', '6', '270000', 'Material: Wood and Plastic.
Display time and temperature at the same time.
Can choose between Celsius and Fahrenheit.
Power supply: 4 AAA batteries or 5V USB adapter.
Size: 15 x 7 x 5 (cm).
Weight: 300 (g).
Products include: 01 clock, 01 USB power cord and user manual.
Display time (12h or 24h), day, month, year.
Sensor brightness according to the surrounding environment.
Alarm 3 times a day.
Electronic thermometer.
Sound sensor technology.
Clear digits with LED technology.
Price: 270K - Free Shipping Nationwide.
Warranty: 6 Months Genuine.', '', 'tableDecor2.jpg','70', '5')
insert into Product values('Whisper', '6', '390000', 'Nice decoration, compact and amazing sound.
Decorate the desk, study corner and be a very unique gift.
Technical parameters:.
Bluetooth Version: 5.0.
Effective distance: About 10m.
Battery capacity: 3.7V 2000mAh.
7.4wH supported protocol: A2DP, AVRCP, HFP, HSP.
Charging interface: Micro USB, DC5V === 2A.
Working time: about 10 hours of calling and listening to music (Average volume).
Standby time: 98h.
Charging time: About 5 hours.
Time LED / Display time: 45 hours.
Battery life: 300 times cycle Battery type: 18650 polymer lithium battery.
Support: Music Hands-free Micro SD / TF (Max 32G).
Features: Support: Bluetooth, TF card, USB, Line in.
Alarm Clock Display Time LCD screen.
Material: ABS plastic.
Speaker size: 140mm * 65mm * 44mm.
Package: 1 x Bluetooth Speaker, 1 x Charging Cable, 1 x User Manual, 1 x 3.5mm Cable.
Price: 390k - Free shipping nationwide.
Warranty: 6 Months genuine.', 'MIRAL LED meter cum Speaker BLUTOOTH AEC BT-501 EXTREMELY', 'tableDecor3.jpg','10', '4')
insert into Product values('FLEXIBLE LIGHTS', '6', '320000', 'Lampshade: 12cmx15.5cm.
Desk lamp body: 37cm + 37cm.
Material: hardened steel pipe with powder coating.
Voltage: 220V ~ 50Hz.
Brackets: Steady, keeping the light always stable without being moved.
Weight: 1kg.
Clamp foot design for easy, secure replacement.
The metal frame design is very sturdy and sturdy.
Insulating magnetic coating.
With 3 foot-body-lamp crank structure, the table lamp can turn all positions very unique - strange and full of fun.
The desk stand and clip base can be table-mounted or table clamp, bookshelf, cabinet is very convenient.
Spinning, easy ball replacement.
Suitable for all needs of work, study, interior decoration.', 'FLEXIBLE LIGHTS', 'tableDecor4.jpg','10', '4')
insert into Product values('HAND PLASMA GLOBES - DECORATIVE LIGHTS', '6', '320000', 'Extremely outstanding on the desk and study.
Size: Globe - diameter 10CM.
Overall Size: 17CM High.
Touching the electric ball will condense to the extreme point and ensure absolute safety.
Using electricity 220V.
Weight 550g.
Price: 320K - Free Shipping Nationwide.
Warranty: 3 Months Genuine.', 'GLOVES PLASMA GLOBAL, used as a sleeping lamp or decorative lamp extremely - BEAUTIFUL - SUBJECT', 'tableDecor5.jpg','30', '4')
insert into Product values('MULTIPLE COLOR FLOWER LIGHT SO BEAUTIFUL', '6', '180000', 'Suitable for a luxury gift, send love to your lover, friends, business partners, or customers.
In addition, this is a decorative product that combines a very unique function of the nightlight. Normally it is seen as a model sphere, when the lights are turned on it becomes shimmering and can be combined as a nightlight.
Bring sophistication and uniqueness to your bedroom, your loved one, and let your brand logo shine in your clients home.
Size: 150x175MM.
Material: Wood + handmade rattan.
Color: WHITE, BLUE, PINK, TIN.
Power use: 220V / 50Hz.
Control switch: Control button.
Price: 180K.
Warranty: 6 Months Genuine.', '', 'tableDecor6.jpg','30', '4')
insert into Product values('BLUTOOTH SPEAKER AEC BQ615 PRO RGB LED WHITE', '6', '480000', 'Bass is big and strong, compact design for easy portability.
RGB LED system with many beautiful modes.
Product Features: Bluetooth Play / LED Light / FM Radio / Memory Card Playback / NFC Function.
Powerful 40mm speaker, transmitting more powerful sound.
Support reading 32G SD card.
Painted stainless steel mesh.
Speaker parameters: 40MMx3W.
Output power: 3Wx2.
Frequency response: 20Hz-20KHz.
Sensitivity: 100db ± 5db.
Signal / noise ratio: ≥90DB.
Distortion: .5 0.5%.
Bluetooth version: 3.0.
Product size: 157mm high, 70mm in diameter.
Battery life: 2000mAh - use 8-10 hours depending on mode and volume.
Price: 480K.
Warranty: 6 months genuine.', 'AEC BQ615 PRO BLUTOOTH SPEAKER for the ultimate music experience', 'tableDecor7.jpg','30', '4')
insert into Product values('ELECTRONIC LED WATCH BLACK HJ1019', '6', '110000', 'Electronic desktop clock with many colors.
Multi-function: time display; date; temperature ... 2 time modes: 12h / 24h.
Uses 3 AAA batteries (not included).
Automatic sensor backlight LED screen: automatically illuminates at night. You can watch the time at night thanks to the comfortable backlight function and not affect your sleep.
Modern and fashionable design suitable to decorate any space.
Dimensions: 13.8 x 8 x 4.5 (cm).
Price: 110K.
Warranty 3 months.', '', 'tableDecor8.png','30', '4')
insert into Product values('ELECTRONIC LED WATCH WHITE HJ1019', '6', '110000', 'Electronic desktop clock with many colors.
Multi-function: time display; date; temperature ... 2 time modes: 12h / 24h.
Uses 3 AAA batteries (not included).
Automatic sensor backlight LED screen: automatically illuminates at night. You can watch the time at night thanks to the comfortable backlight function and not affect your sleep.
Modern and fashionable design suitable to decorate any space.
Dimensions: 13.8 x 8 x 4.5 (cm).
Price: 110K.
Warranty 3 months.', '', 'tableDecor9.png','30', '4')
insert into Product values('3D DIGITAL LED WATCH FOR BLACK FRAME LED WHITE', '6', '230000', '', '', 'tableDecor10.png','30', '4')
insert into Product values('PLASMA BRIDGE BRIDGE OF VEHICLES - DECORATIVE LIGHT', '6', '320000', 'Extremely outstanding on the desk and study.
Size: Globe - diameter 10CM.
Overall Size: 17CM High.
Touching the electric ball will condense to the extreme point and ensure absolute safety.
Using electricity 220V.
Weight 550g.
Price: 320K - Free Shipping Nationwide.
Warranty: 3 Months Genuine.', 'GLOVES PLASMA GLOBAL, used as a sleeping lamp or decorative lamp extremely - BEAUTIFUL - SUBJECT', 'tableDecor11.png','30', '4')
insert into Product values('RED FLOOR RGB LED LIGHT BRIDGE', '6', '280000', 'The moonlight is super beautiful, the product can both be decorated like a night light, and can conceal the gaps in your room. You will bring the whole moon into your lovely room!
The new version has many outstanding improvements compared to the old version
The inside is equipped with a multicolored led board with an impact sensor from which the light will change color every time you tap on the outer shell.
The light base is made of natural wood consisting of 3 bars assembled by the tabs to make the lamp not roll and create a very high aesthetic.
Full box includes: lovely gift box, 1 moonlight, 1 wooden base, 1 USB charging cable.
Price: 280K.
Warranty: 6 Months Genuine.', '', 'tableDecor12.jpg','30', '4')

--figure
insert into Product values('GROOT MODEL OF PLANT - PUNCH JAR', '7', '90000', 'Extremely unique baby groot model with sophisticated design is no different from guardians of the galaxy.
Baby groot: used to plant trees.
Baby groot: used to hold learning tools.
Baby groot: used to decorate the workspace, fish tank, cafe.
Material: Made of PVC.
Dimension: 11 * 10 * 14cm (Length x Width X Height).
Price: 90k.', '', 'figure1.jpg','50', '4')
insert into Product values('MODEL JOKER PHONE HOLDER SHAKER 12CM', '7', '130000', 'JOKER SHOCKING MODEL EXTREMELY KUTE.
HAVE A CONFIDENTIAL PHONE CHANNEL.
MATERIAL: PVC.
SIZE: 12CM.
PRICE: 130K.', '', 'figureMD2.png','50', '4')
insert into Product values('MODEL FOR KAWS 12CM KAWS PHONE HOLDER SHAKE', '7', '130000', 'THE KAWS SHAKER IS EXTREMELY KUTE.
HAVE A CONFIDENTIAL PHONE CHANNEL.
MATERIAL: PVC.
SIZE: 12CM.
PRICE: 130K.', '', 'figureMD3.png','50', '4')
insert into Product values('Smoking Doraemon', '7', '130000', '', '', 'figureMD4.jpg','50', '4')
insert into Product values('GOKU', '7', '130000', '', '', 'figure5.png','50', '4')
insert into Product values('MODEL DEATH NOTE RYUK 24CM', '7', '140000', 'Material: PVC.
Model Size: 24CM High - Wingspan 26CM.
Model Weight: 150g.
Price: 140k.', 'Model DEATH NOTE RYUK IS EXTREMELY', 'figure6.png','50', '4')
insert into Product values('HARLEY QUINN CHIBI KUTE MODEL', '7', '140000', 'Material: PVC.
Model Size: 14cm High.
Model Weight: 150g.
Price: 140k.', 'Model Harley Quinn extreme Kute', 'figure7.png','50', '4')
insert into Product values('17CM HULK BUSTER MODEL - MULTIPLE COMBATING', '7', '119000', 'Material: PVC.
Model Size: 17CM High.
Model Weight: 150g.
Price: 119K.', 'Model HULK BUSTER', 'figure8.png','50', '4')

--Blanket, Curtain, Pillows
insert into Product values('Coating Machine - Washing CMW001', '8', '350000', 'The refrigerator cover - premium washing machine protects the top of the washing machine refrigerator, and keeps the top of the refrigerator clean from all dirt and good waterproof.
Decoration for the refrigerator and room space more vivid.
The two sides have more small compartments for storing things. Help you save space and more convenience for the rins and kitchen.
The towel fits the top part of the cabinet, covering both sides of the cabinet.
Size: 60x140cm.
Price: 350,000 VND.', '', 'BCP1.jpg','50', '3')
insert into Product values('Coating Machine - Washing CMW002', '8', '350000', 'The refrigerator cover - premium washing machine protects the top of the washing machine refrigerator, and keeps the top of the refrigerator clean from all dirt and good waterproof.
Decoration for the refrigerator and room space more vivid.
The two sides have more small compartments for storing things. Help you save space and more convenience for the rins and kitchen.
The towel fits the top part of the cabinet, covering both sides of the cabinet.
Size: 60x140cm.
Price: 350,000 VND.', '', 'BCP2.jpg','50', '3')
insert into Product values('Coating Machine - Washing CMW003', '8', '350000', 'The refrigerator cover - premium washing machine protects the top of the washing machine refrigerator, and keeps the top of the refrigerator clean from all dirt and good waterproof.
Decoration for the refrigerator and room space more vivid.
The two sides have more small compartments for storing things. Help you save space and more convenience for the rins and kitchen.
The towel fits the top part of the cabinet, covering both sides of the cabinet.
Size: 60x140cm.
Price: 350,000 VND.', '', 'BCP3.jpg','50', '3')
insert into Product values('Coating Machine - Washing CMW004', '8', '350000', 'The refrigerator cover - premium washing machine protects the top of the washing machine refrigerator, and keeps the top of the refrigerator clean from all dirt and good waterproof.
Decoration for the refrigerator and room space more vivid.
The two sides have more small compartments for storing things. Help you save space and more convenience for the rins and kitchen.
The towel fits the top part of the cabinet, covering both sides of the cabinet.
Size: 60x140cm.
Price: 350,000 VND.', '', 'BCP4.jpg','50', '3')
insert into Product values('DCG01 Pillow Set', '8', '1450000', 'choices and gives customers the products quiltquilted cotton exports Qoc Korea, Europe and the US With 100% cotton cool,  with cool eye motifs, soft . Top quality, each blanket model is very careful with every needle thread. The quilt is not too thick or thin, so it is suitable for all weather. Easy to use, machine washable, does not fade or fade.', '', 'BCP5.jpg','50', '3')
insert into Product values('DCG02 Pillow Set', '8', '1450000', 'choices and gives customers the products quiltquilted cotton exports Qoc Korea, Europe and the US With 100% cotton cool,  with cool eye motifs, soft . Top quality, each blanket model is very careful with every needle thread. The quilt is not too thick or thin, so it is suitable for all weather. Easy to use, machine washable, does not fade or fade.', '', 'BCP6.jpg','50', '3')
insert into Product values('DCG03 Pillow Set', '8', '1450000', 'choices and gives customers the products quiltquilted cotton exports Qoc Korea, Europe and the US With 100% cotton cool,  with cool eye motifs, soft . Top quality, each blanket model is very careful with every needle thread. The quilt is not too thick or thin, so it is suitable for all weather. Easy to use, machine washable, does not fade or fade.', '', 'BCP7.jpg','50', '3')
insert into Product values('DCG04 Pillow Set', '8', '1450000', 'choices and gives customers the products quiltquilted cotton exports Qoc Korea, Europe and the US With 100% cotton cool,  with cool eye motifs, soft . Top quality, each blanket model is very careful with every needle thread. The quilt is not too thick or thin, so it is suitable for all weather. Easy to use, machine washable, does not fade or fade.', '', 'BCP8.jpg','50', '3')

--Home Accessories
insert into Product values('Vase of flowers', '9', '200000', '', '', 'HomeAccessories1.jpg','70', '6')
insert into Product values('Set 5 Cup Teapot', '9', '500000', 'The super beautiful porcelain tea set is made of high quality ceramic material, so it keeps the heat very well and is safe for health.', '', 'HomeAccessories2.jpg','70', '6')
insert into Product values('Blue Japanese 4 Cup Teapot', '9', '500000', 'The super beautiful Japanese porcelain tea set is made of high quality ceramic material, so it keeps the heat very well and is safe for health.
Not only decorative items, but also for the whole family to enjoy delicious, richly emotional cups of tea or to welcome guests to the house. 
The set includes 4 cups, 1 kettle & 1 beautiful tea jar', '', 'HomeAccessories3.jpg','70', '6')
insert into Product values('Decoration Shelves', '9', '400000', '', '', 'HomeAccessories4.jpg','70', '6')
insert into Product values('Decoration Shelves', '9', '250000', '', '', 'HomeAccessories5.jpg','70', '6')
insert into Product values('Decoration Shelves', '9', '400000', '', '', 'HomeAccessories6.jpg','70', '6')
insert into Product values('Decoration Shelves', '9', '400000', '', '', 'HomeAccessories7.jpg','70', '6')

insert into Evaluate values('Product is pretty good','4',GETDATE(),'2','1')
insert into Evaluate values('Product is pretty good','5',GETDATE(),'2','2')
insert into Evaluate values('Product is pretty good','4',GETDATE(),'3','4')
insert into Evaluate values('Product is pretty good','3',GETDATE(),'4','5')
insert into Evaluate values('Product is pretty good','4',GETDATE(),'3','8')
insert into Evaluate values('Product is pretty good','3',GETDATE(),'4','9')
insert into Evaluate values('Product is pretty good','4',GETDATE(),'6','12')
insert into Evaluate values('Product is pretty good','3',GETDATE(),'5','12')
insert into Evaluate values('Product is pretty good','5',GETDATE(),'7','12')
insert into Evaluate values('Product is pretty good','4',GETDATE(),'2','14')
insert into Evaluate values('Product is pretty good','3',GETDATE(),'2','17')
insert into Evaluate values('Product is pretty good','5',GETDATE(),'2','19')
insert into Evaluate values('Product is pretty good','3',GETDATE(),'4','21')
insert into Evaluate values('Product is pretty good','5',GETDATE(),'5','21')
insert into Evaluate values('Product is pretty good','4',GETDATE(),'2','22')
insert into Evaluate values('Product is pretty good','4',GETDATE(),'3','25')
insert into Evaluate values('Product is pretty good','5',GETDATE(),'2','27')
insert into Evaluate values('Product is pretty good','4',GETDATE(),'4','29')
insert into Evaluate values('Product is pretty good','3',GETDATE(),'3','32')
insert into Evaluate values('Product is pretty good','5',GETDATE(),'2','35')
insert into Evaluate values('Product is pretty good','3',GETDATE(),'2','36')
insert into Evaluate values('Product is pretty good','4',GETDATE(),'4','36')
insert into Evaluate values('Product is pretty good','5',GETDATE(),'2','37')
insert into Evaluate values('Product is pretty good','4',GETDATE(),'2','40')
insert into Evaluate values('Product is pretty good','3',GETDATE(),'2','40')
insert into Evaluate values('Product is pretty good','3',GETDATE(),'2','42')
insert into Evaluate values('Product is pretty good','4',GETDATE(),'3','47')
insert into Evaluate values('Product is pretty good','4',GETDATE(),'2','48')
insert into Evaluate values('Product is pretty good','4',GETDATE(),'5','49')
insert into Evaluate values('Product is pretty good','4',GETDATE(),'2','50')
insert into Evaluate values('Product is pretty good','5',GETDATE(),'2','53')
insert into Evaluate values('Product is pretty good','4',GETDATE(),'6','55')
insert into Evaluate values('Product is pretty good','4',GETDATE(),'2','55')
insert into Evaluate values('Product is pretty good','3',GETDATE(),'2','57')
insert into Evaluate values('Product is pretty good','5',GETDATE(),'4','59')
insert into Evaluate values('Product is pretty good','4',GETDATE(),'2','60')
insert into Evaluate values('Product is pretty good','4',GETDATE(),'5','61')

select * from Product where productID = 2

select * from Bill

update Bill set status = 2 where BillID = 'c4ca4238a0b923820dcc509a6f75849b'

select b.BillID from Bill b, Product p, Brand bd
where b.productid = p.productID and p.brandID = bd.brandID and bd.brandID = 3
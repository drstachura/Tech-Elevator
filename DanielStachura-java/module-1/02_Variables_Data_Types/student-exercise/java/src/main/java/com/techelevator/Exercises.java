package com.techelevator;

public class Exercises {

	public static void main(String[] args) {

        /*
        1. 4 birds are sitting on a branch. 1 flies away. How many birds are left on
        the branch?
        */

		// ### EXAMPLE:
		int initialNumberOfBirds = 4;
		int birdsThatFlewAway = 1;
		int remainingNumberOfBirds = initialNumberOfBirds - birdsThatFlewAway;

		System.out.println("Birds left: " + remainingNumberOfBirds);

        /*
        2. There are 6 birds and 3 nests. How many more birds are there than
        nests?
        */

		// ### EXAMPLE:
		int numberOfBirds = 6;
		int numberOfNests = 3;
		int numberOfExtraBirds = numberOfBirds - numberOfNests;

		System.out.println(numberOfExtraBirds + " more birds");

        /*
        3. 3 raccoons are playing in the woods. 2 go home to eat dinner. How
        many raccoons are left in the woods?
        */

		int numberOfRacoons = 3;
		int wentHome = 2;
		int raccoonsLeft = numberOfRacoons - wentHome;

		System.out.println(raccoonsLeft + " raccoon left in the woods");

        /*
        4. There are 5 flowers and 3 bees. How many less bees than flowers?
        */

		int numberOfFlowers = 5;
		int numberOfBees = 3;
		int lessBeesThanFlowers = numberOfFlowers - numberOfBees;

		System.out.println("There are " + lessBeesThanFlowers + " bees less than flowers");

        /*
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now?
        */

		int initialPigeon = 1;
		int joiningPigeon = 1;
		int pigeonsEatingBreadcrumbs = initialPigeon + joiningPigeon;

		System.out.println("There are " + pigeonsEatingBreadcrumbs + " pigeons eating breadcrumbs");

        /*
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now?
        */

		int currentOwls = 3;
		int joiningOwls = 2;
		int owlsOnTheFence = currentOwls + joiningOwls;

		System.out.println("There are now " + owlsOnTheFence + " Owls hanging out");

        /*
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home?
        */

		int workingBeavers = 2;
		int swimmingBeavers = 1;
		int beaversStillWorking = workingBeavers - swimmingBeavers;

		System.out.println("There is " + beaversStillWorking + " beaver still working");


        /*
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all?
        */

		int toucansInTree = 2;
		int joiningToucans = 1;
		int toucansOnTreeLimb = toucansInTree + joiningToucans;

		System.out.println(toucansOnTreeLimb + " Toucans in all");

        /*
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts?
        */

		int squirrelsInTree = 4;
		int numberOfNuts = 2;
		int squirrelsMoreThanNuts = squirrelsInTree - numberOfNuts;

		System.out.println(squirrelsMoreThanNuts + " more squirrels than nuts");

        /*
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find?
        */

		double quarter = .25;
		double dime = .10;
		double nickel = .05;
		double amountOfMoney = quarter + dime + 2 * nickel;

		System.out.println("$" + amountOfMoney);

        /*
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all?
        */

		int mrsBrierMuffins = 18;
		int mrsMacAdamsMuffins = 20;
		int mrsFlanneryMuffins = 17;
		int firstGradeMuffins = mrsBrierMuffins + mrsMacAdamsMuffins + mrsFlanneryMuffins;

		System.out.println("First grade made " + firstGradeMuffins + " muffins");

        /*
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */

		double yoyoPrice = .24;
		double whistlePrice = .14;
		double totalSpent = yoyoPrice + whistlePrice;

		System.out.println(totalSpent + " spent on toys");

        /*
        13. Mrs. Hilt made 5 Rice Krispie Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */

		int largeMallows = 8;
		int miniMallows = 10;
		int totalMallowsUsed = largeMallows + miniMallows;

		System.out.println(totalMallowsUsed + " Mallows were used in total");

        /*
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */

		int snowAtMrsHiltHouse = 29;
		int snowAtBrecknockElementary = 17;
		int differenceInSnow = snowAtMrsHiltHouse - snowAtBrecknockElementary;

		System.out.println("Mrs Hilt house received " + differenceInSnow + " inches of more snow");

        /*
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2 on a pencil
        case. How much money does she have left?
        */

		int hiltStartingCash = 10;
		int toyTruckCost = 3;
		int pencilCost = 2;
		int moneyLeft = hiltStartingCash - toyTruckCost - pencilCost;

		System.out.println("after her purchases, Mrs Hilt has $" + moneyLeft + " leftover");

        /*
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */

		int collectionOfMarbles = 16;
		int marblesLost = 7;
		int marblesLeft = collectionOfMarbles - marblesLost;

		System.out.println("after josh lost his marbles, he now has " + marblesLeft);

        /*
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */

		int startingShells = 19;
		int totalCollection = 25;
		int shellsToBeCollected = totalCollection - startingShells;

		System.out.println(shellsToBeCollected + " need to be collected");

        /*
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */

		int totalBalloons = 17;
		int redBalloons = 8;
		int greenBalloons = totalBalloons - redBalloons;

		System.out.println("there are " + greenBalloons + " green balloons");

        /*
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */

		int startingBooks = 38;
		int addedBooks = 10;
		int totalBooks = startingBooks + addedBooks;

		System.out.println("there are now " + totalBooks + " on the shelf");

        /*
        20. A bee has 6 legs. How many legs do 8 bees have?
        */

		int oneBeesLegs = 6;
		int beeAmount = 8;
		int totalAmountOfLegs = oneBeesLegs * beeAmount;

		System.out.println("8 bees have " + totalAmountOfLegs + " legs");

        /*
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */

		double iceCreamConeCost = 0.99;
		double twoCones = iceCreamConeCost * 2;

		System.out.println("2 cones would cost $" + twoCones);

        /*
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */

		int totalRocksNeeded = 125;
		int rocksOwned = 64;
		int remainingRocksNeeded = totalRocksNeeded - rocksOwned;

		System.out.println(remainingRocksNeeded + " rocks are still needed");

        /*
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */

		int startingMarbles = 38;
		int lostMarbles = 15;
		int remainingMarbles = startingMarbles - lostMarbles;

		System.out.println(remainingMarbles + " marbles left");

        /*
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */

		int totalMilesToDrive = 78;
		int milesDrove = 32;
		int milesRemaining = totalMilesToDrive - milesDrove;

		System.out.println(milesRemaining + " miles left to drive");

        /*
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time did she spend shoveling snow?
        */

		int snowShoveledMorning = 90;
		int snowShoveledAfternoon = 45;
		int totalTimeShoveling = snowShoveledMorning + snowShoveledAfternoon;

		System.out.println(totalTimeShoveling + " minutes spent shoveling");

        /*
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */

		int hotDogsBought = 6;
		double hotDogCost = .50;
		double totalPaidForHotdog = (double) hotDogsBought *  hotDogCost;

		System.out.println("$" + totalPaidForHotdog + " was paid for hotdogs");

        /*
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */

		double moneyOwned = .50;
		double pencilsCost = .07;
		double pencilsBought = moneyOwned / pencilsCost;

		System.out.println("she can buy " + pencilsBought + " pencils");


        /*
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */

		int butterfliesSeen = 33;
		int orangeButterfly = 20;
		int redButterfly = butterfliesSeen - orangeButterfly;

		System.out.println("there are " +redButterfly + " red butterflies");

        /*
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */

		double amountTendered = 1.00;
		double candyCost = .54;
		double changeReceived = amountTendered - candyCost;

		System.out.println("kate received $" + changeReceived + " back");


        /*
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */

		int treesAlreadyInYard = 13;
		int treesPlanted = 12;
		int totalTreesInYard = treesAlreadyInYard + treesPlanted;

		System.out.println("there are now " + totalTreesInYard + " trees in the yard");

        /*
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */

		int hoursInaDAy = 24;
		int daysUntilGrandmaSeen = 2;
		int hoursUntilGrandmaSeen = hoursInaDAy * daysUntilGrandmaSeen;

		System.out.println("she will see grandma in " + hoursUntilGrandmaSeen + " hours");

        /*
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */

		int numberOfCousins = 4;
		int gumToGiveEach = 5;
		int gumNeeded = numberOfCousins * gumToGiveEach;

		System.out.println("Kim needs " + gumNeeded + " pieces");

        /*
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */

		int dansMoney = 3;
		int candyBarCost = 1;
		int moneyLeftover = dansMoney - candyBarCost;

		System.out.println("$" + moneyLeftover + " left");

        /*
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */

		int boatsInLake = 5;
		int peopleOnEachBoat = 3;
		int totalPeopleOnBoats = boatsInLake * peopleOnEachBoat;

		System.out.println("there are " + totalPeopleOnBoats + " people on boats in the lake");

        /*
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */

		int startingLegos = 380;
		int lostLegos = 57;
		int legosLeft = startingLegos - lostLegos;

		System.out.println("she has " +legosLeft + " legos left");

        /*
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */

		int muffinsNeeded = 83;
		int currentMuffins = 35;
		int muffinsToBake = muffinsNeeded - currentMuffins;

		System.out.println(muffinsToBake + " muffins to bake");

        /*
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */

		int willyCrayons = 1400;
		int lucyCrayons = 290;
		int willyMoreCrayonsThanLucy = willyCrayons - lucyCrayons;

		System.out.println("Willy has " + willyMoreCrayonsThanLucy + " more crayons than lucy");

        /*
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */

		int stickerPerPage = 10;
		int pagesOfStickers = 22;
		int totalAmountOfStickers = stickerPerPage * pagesOfStickers;

		System.out.println(totalAmountOfStickers + " total stickers");

        /*
        39. There are 96 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */

		int cupcakesToShare = 96;
		int numberOfChildren = 8;
		int cupcakesPerChild = cupcakesToShare / numberOfChildren;

		System.out.println("Each gets " + cupcakesPerChild + " cupcake");

        /*
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If each jar is to contain six cookies each, how many
        cookies will not be placed in a jar?
        */
		int madeCookies = 47;
		int cookiesPerJar = 6;
		int cookiesNotPlaced = madeCookies % cookiesPerJar;

		System.out.println(cookiesNotPlaced + " cookies not placed");

        /*
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received and equal number of croissants,
        how many will be left with Marian?
        */

		int totalPreparedCroissant = 59;
		int numberOfNeighbors = 8;
		int croissantLeftToMarian =  totalPreparedCroissant % numberOfNeighbors;

		System.out.println(croissantLeftToMarian + " left for Marian");

        /*
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */

		int totalCookieAmount = 276;
		int cookiesPerTray = 12;
		int numberOfTraysNeeded = totalCookieAmount / cookiesPerTray;

		System.out.println(numberOfTraysNeeded + " trays");

        /*
        43. Marian’s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */

		int pretzelsMade = 480;
		int pretzelsPerServing = 12;
		int numberOfServingsPossible = pretzelsMade / pretzelsPerServing;

		System.out.println(numberOfServingsPossible + " servings");

        /*
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */

		int cupcakesAvailable = 51;
		int cupcakesPerBox = 3;
		int numberOfBoxesGiven = cupcakesAvailable / cupcakesPerBox;

		System.out.println(numberOfBoxesGiven + " boxes given");

        /*
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */

		int totalCarrotSticksPrep = 74;
		int peopleSplittingCarrotSticks = 12;
		int carrotSticksUneaten = totalCarrotSticksPrep % peopleSplittingCarrotSticks;

		System.out.println(carrotSticksUneaten + " uneaten carrot sticks");

        /*
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */

		int teddysGathered = 98;
		int teddysPerShelf = 7;
		int shelvesfilled = teddysGathered / teddysPerShelf;

		System.out.println(shelvesfilled + " shelves filled");

        /*
        47. Susie’s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */

		int totalPictures = 480;
		int picsPerAlbum = 20;
		int albumsneeded = totalPictures / picsPerAlbum;

		System.out.println(albumsneeded + " albums");

        /*
        48. Joe, Susie’s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */

		int collectedCards = 94;
		int cardsPerBox = 8;
		int cardsNotFilled =  collectedCards % cardsPerBox;

		System.out.println(cardsNotFilled + " cards");

        /*
        49. Susie’s father repaired the bookshelves in the reading room. If he has
        210 books to be distributed equally on the 10 shelves he repaired,
        how many books will each shelf contain?
        */

		int totalNumberOfBooks = 210;
		int numberOfShelves = 10;
		int booksPerShelf = totalNumberOfBooks / numberOfShelves;

		System.out.println(booksPerShelf + " books per shelf");

        /*
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */

		double bakedCroissants = 17;
		double amountOfGuest = 7;
		double croissantPerGuest = bakedCroissants / amountOfGuest;

		System.out.println(croissantPerGuest + " per guest");

        /*
            CHALLENGE PROBLEMS
        */

        /*
        Bill and Jill are house painters. Bill can paint a 12 x 14 room in 2.15 hours, while Jill averages
        1.90 hours. How long will it take the two painter working together to paint 5 12 x 14 rooms?
        Hint: Calculate the hourly rate for each painter, combine them, and then divide the total walls in feet by the combined hourly rate of the painters.
        Challenge: How many days will it take the pair to paint 623 rooms assuming they work 8 hours a day?.
        */

        /*
        Create and assign variables to hold your first name, last name, and middle initial. Using concatenation,
        build an additional variable to hold your full name in the order of last name, first name, middle initial. The
        last and first names should be separated by a comma followed by a space, and the middle initial must end
        with a period.
        Example: "Hopper, Grace B."
        */

        /*
        The distance between New York and Chicago is 800 miles, and the train has already travelled 537 miles.
        What percentage of the trip has been completed?
        Hint: The percent completed is the miles already travelled divided by the total miles.
        Challenge: Display as an integer value between 0 and 100 using casts.
        */


	}

}

package com.example.grant20.models.DB;

public class Query {
    public static final String checkAuth = "SELECT 1 FROM authentication JOIN employee USING(mail) WHERE mail=? " +
            "AND password =? AND authentication.deleted IS NULL AND confirm = 1 AND employee.deleted IS NULL";
    public static final String createUser = "SELECT mail,name,role FROM employee WHERE mail=?";

    public static final String registerUser = "INSERT INTO employee(mail,name,role)\n" +
                                                                            "VALUES\n" +
                                                                            "(?,?,2);\n";
    public static final String deleteComplexById = "UPDATE `complex` SET `deleted` = 1 WHERE id =?";
    public static final String deleteHouseById = "UPDATE `house` SET `deleted` = 1 WHERE id=?";
    public static final String deleteApartmentById = "UPDATE `apartment` SET `deleted` = 1 WHERE id=?";
    public static final String getPeople = "SELECT * FROM employee WHERE `deleted` IS NULL ORDER BY confirm ";
    public static final String updatePersonConfirm = "UPDATE `employee` \n" +
                                                        "SET `confirm`=1\n" +
                                                        "WHERE `mail`=?;";

    public static final String updatePersonById = "UPDATE `employee` \n" +
                                                        "SET `name`=? \n" +
                                                        "WHERE `mail`=?;";
    
    public static final String updateHouseById = "UPDATE `house` \n" +
                                                    "SET `number`=?,\n" +
                                                    "`addedValue`=?,\n" +
                                                    "`buildingCosts`=?,\n" +
                                                    "`complexID`=(SELECT id FROM complex WHERE street = ? AND name = ? AND `deleted` IS NULL) \n" +
                                                    "WHERE id=?;";
    public static final String registerAuthorizationData  = "INSERT INTO authentication(mail,password)\n" +
                                                                "VALUES (?,?);";
    public static final String checkSoldApartmentsOnComplex = "SELECT IF(\"sold\"=ANY(SELECT statusSale FROM complex JOIN " +
            "house ON house.complexID=complex.id JOIN apartment ON apartment.houseID = house.id WHERE complexID = ? AND apartment.deleted IS NULL AND house.deleted IS NULL AND complex.deleted IS NULL),1,0)";
    public static final String selectHouseList = "SELECT house.id, complex.name, complex.street, IF(house.number IS NULL OR " +
            "house.number = \"\", \"Без номера\", house.number) AS number, complex.statusConstruction, IF(sold_ap.sold IS NULL, 0, sold_ap.sold) " +
            "AS sold_apartments, IF(not_sold_ap.not_sold IS NULL, 0, not_sold_ap.not_sold) AS not_sold_apartments,\n" +
            "            house.addedValue, house.buildingCosts FROM house JOIN complex ON house.complexID=complex.id\n" +
            "                        LEFT JOIN (SELECT houseID, COUNT(id) AS sold\n" +
            "                              FROM apartment  \n" +
            "                              WHERE deleted IS NULL AND statusSale = \"sold\"\n" +
            "                              GROUP BY houseID) sold_ap ON house.id=sold_ap.houseID\n" +
            "                        LEFT JOIN (\n" +
            "                            SELECT houseID, COUNT(id) AS not_sold\n" +
            "                            FROM apartment\n" +
            "                            WHERE deleted IS NULL AND statusSale = \"ready\"\n" +
            "                            GROUP BY houseID\n" +
            "                            ) not_sold_ap ON house.id=not_sold_ap.houseID\n" +
            "            WHERE complex.deleted IS NULL AND complex.id = ? ORDER BY complex.name, complex.street, house.number;";
    public static final String insertHouse = "INSERT INTO `house`(`number`, `addedValue`, `buildingCosts`, `complexID`)\n" +
            "VALUES (?, ?, ?, (SELECT id FROM complex WHERE street = ? AND name = ?));";
    public static final String insertComplex = "INSERT INTO `complex`\n" +
            "(`name`, `city`, `street`, `statusConstruction`, `addedValue`, `buildingCosts`) VALUES \n" +
            "(?,?,?,?,?,?);";
    public static final String updateComplex = "UPDATE `complex` SET \n" +
                                                    "`name`=?,\n" +
                                                    "`city`=?,\n" +
                                                    "`street`=?,\n" +
                                                    "`statusConstruction`=?,\n" +
                                                    "`addedValue`=?,\n" +
                                                    "`buildingCosts`=? \n" +
                                                    "WHERE id=?;";
    public static final String getComplexNames = "SELECT DISTINCT name,street FROM complex WHERE deleted IS NULL";
    public static final String getStreetNamesWhereComplex = "SELECT DISTINCT name,street FROM complex WHERE name=?";
    public static final String updateApartmentById = "UPDATE `apartment`\n" +
            "SET\n" +
            "`houseID`= (SELECT house.id FROM house WHERE number=? AND complexID = (SELECT complex.id FROM complex WHERE name =? AND city =? AND street=? )),\n" +
            "`apartmentNumber`=?,\n" +
            "`area`=?,\n" +
            "`rooms`=?,\n" +
            "`entrance`=?,\n" +
            "`floor`=?,\n" +
            "`statusSale`=?,\n" +
            "`addedValue`=?,\n" +
            "`cost`=?\n" +
            "WHERE id = ?";
    public static final String getApartments = "SELECT apartment.id, complex.name, apartment.apartmentNumber, CONCAT(\"г. \",complex.city,\" ул. \", " +
            "complex.street, \" д.\", house.number, \" кв.\", apartmentNumber) AS address,\n" +
            "\t\tapartment.area, apartment.rooms, apartment.entrance, apartment.floor, apartment.statusSale, complex.id,apartment.cost,apartment.addedValue,apartment.houseID\n" +
            "FROM apartment JOIN house ON apartment.houseID=house.id JOIN complex ON house.complexID=complex.id\n" +
            "WHERE apartment.deleted IS NULL AND house.deleted IS NULL AND complex.deleted IS NULL;";
    public static final String getConcatedApartmentAddressByHouse = "SELECT DISTINCT CONCAT('г. ',complex.city,' ул. ',complex.street,' д. ',house.number) as address " +
            "FROM complex JOIN house ON house.complexID=complex.id WHERE complex.name =? AND complex.deleted IS NULL AND house.deleted IS NULL;";
    public static final String insertApartment = "INSERT INTO `apartment`" +
            "(`houseID`, `apartmentNumber`, `area`, `rooms`, `entrance`, `floor`, `statusSale`, `addedValue`, `cost`) \n" +
            "VALUES (" +
            "(SELECT house.id FROM house WHERE number=? AND complexID = (SELECT complex.id FROM complex WHERE name =? AND city =? AND street=?)) ," +
            "?,?,?,?,?,?,?,?);";
    public static final String getHouses = "SELECT house.id, complex.name, complex.street, IF(house.number IS NULL " +
            "OR house.number = \"\", \"Без номера\", house.number) AS number, complex.statusConstruction, IF(sold_ap.sold IS NULL, " +
            "0, sold_ap.sold) AS sold_apartments, " +
            "IF(not_sold_ap.not_sold IS NULL, 0, not_sold_ap.not_sold) AS not_sold_apartments\n" +
            "FROM house JOIN complex ON house.complexID=complex.id\n" +
            "            LEFT JOIN (SELECT houseID, COUNT(id) AS sold\n" +
            "                  FROM apartment  \n" +
            "                  WHERE deleted IS NULL AND statusSale = \"sold\"\n" +
            "                  GROUP BY houseID) sold_ap ON house.id=sold_ap.houseID\n" +
            "            LEFT JOIN (\n" +
            "                SELECT houseID, COUNT(id) AS not_sold\n" +
            "                FROM apartment  \n" +
            "                WHERE deleted IS NULL AND statusSale = \"ready\"\n" +
            "                GROUP BY houseID\n" +
            "                ) not_sold_ap ON house.id=not_sold_ap.houseID\n" +
            "WHERE house.deleted IS NULL AND complex.deleted IS NULL\n" +
            "ORDER BY complex.name, complex.street, house.number;";
    public static final String getAllFromHouses = "SELECT house.id, complex.name, complex.street, IF(house.number IS NULL " +
            "OR house.number = \"\", \"Без номера\", house.number) AS number, complex.statusConstruction, IF(sold_ap.sold IS NULL, " +
            "0, sold_ap.sold) AS sold_apartments, IF(not_sold_ap.not_sold IS NULL, 0, not_sold_ap.not_sold) AS not_sold_apartments,\n" +
            "house.addedValue, house.buildingCosts FROM house JOIN complex ON house.complexID=complex.id\n" +
            "            LEFT JOIN (SELECT houseID, COUNT(id) AS sold\n" +
            "                  FROM apartment  \n" +
            "                  WHERE deleted IS NULL AND statusSale = \"sold\"\n" +
            "                  GROUP BY houseID) sold_ap ON house.id=sold_ap.houseID\n" +
            "            LEFT JOIN (\n" +
            "                SELECT houseID, COUNT(id) AS not_sold\n" +
            "                FROM apartment  \n" +
            "                WHERE deleted IS NULL AND statusSale = \"ready\"\n" +
            "                GROUP BY houseID\n" +
            "                ) not_sold_ap ON house.id=not_sold_ap.houseID\n" +
            "WHERE house.deleted IS NULL AND complex.deleted IS NULL\n" +
            "ORDER BY complex.name, complex.street, house.number;";
    public static final String getComplexes = "SELECT complex.id, complex.name, complex.statusConstruction, " +
            "COUNT(house.id) AS house_count, complex.city,complex.street,complex.addedValue,complex.buildingCosts\n" +
            "FROM complex LEFT JOIN house ON complex.id=house.complexID\n" +
            "WHERE house.deleted IS NULL AND complex.deleted IS NULL\n" +
            "GROUP BY complex.id\n" +
            "ORDER BY complex.city, complex.statusConstruction";

    public static final String getReport = "SELECT apartment.id AS apartmentId, apartment.apartmentNumber, apartment.area, apartment.rooms, apartment.statusSale, " +
            "apartment.addedValue AS apartmentAddedValue, house.id AS houseId, house.number AS houseNumber, house.addedValue AS houseAddedValue, house.buildingCosts AS houseBuildingCosts, complex.id AS complexId, " +
            "complex.name AS complexName, complex.addedValue AS complexAddedValue, complex.buildingCosts AS complexBuildingCosts,apartment.floor,apartment.cost\n" +
            "FROM apartment JOIN house ON apartment.houseID=house.id JOIN complex ON house.complexID=complex.id WHERE apartment.deleted IS NULL AND house.deleted IS NULL AND complex.deleted IS NULL;";

    public static final String query1 = "SELECT apartment.id AS apartmentId, apartment.apartmentNumber, apartment.area, apartment.rooms, apartment.statusSale, " +
            "apartment.addedValue AS apartmentAddedValue, house.id AS houseId, house.number AS houseNumber, house.addedValue AS houseAddedValue, house.buildingCosts AS houseBuildingCosts, complex.id AS complexId, " +
            "complex.name AS complexName, complex.addedValue AS complexAddedValue, complex.buildingCosts AS complexBuildingCosts,apartment.floor,apartment.cost\n" +
            "FROM apartment JOIN house ON apartment.houseID=house.id JOIN complex ON house.complexID=complex.id WHERE house.id=1 AND apartment.deleted IS NULL AND house.deleted IS NULL AND complex.deleted IS NULL;";

    public static final String query2 = "SELECT apartment.id AS apartmentId, apartment.apartmentNumber, apartment.area, apartment.rooms, apartment.statusSale, " +
            "apartment.addedValue AS apartmentAddedValue, house.id AS houseId, house.number AS houseNumber, house.addedValue AS houseAddedValue, house.buildingCosts AS houseBuildingCosts, complex.id AS complexId, " +
            "complex.name AS complexName, complex.addedValue AS complexAddedValue, complex.buildingCosts AS complexBuildingCosts,apartment.floor,apartment.cost\n" +
            "FROM apartment JOIN house ON apartment.houseID=house.id JOIN complex ON house.complexID=complex.id WHERE complex.id=2 AND apartment.deleted IS NULL AND house.deleted IS NULL AND complex.deleted IS NULL;";

}

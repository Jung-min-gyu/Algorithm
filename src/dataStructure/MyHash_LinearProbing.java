package dataStructure;

public class MyHash_LinearProbing {
    public Slot[] hashTable;

    public MyHash_LinearProbing(Integer size) {
        this.hashTable = new Slot[size];
    }

    public class Slot {
        String key;
        String value;

        public Slot(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public int hashFunc(String key) {
        return (int) (key.charAt(0)) % this.hashTable.length;
    }

    public boolean saveData(String key, String value) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            if (this.hashTable[address].key == key) {
                this.hashTable[address].value = value;
                return true;
            } else {
                Integer currentAddress = address + 1;
                while (this.hashTable[currentAddress] != null) {
                    if (this.hashTable[currentAddress].key == key) {
                        this.hashTable[currentAddress].value = value;
                        return true;
                    } else {
                        currentAddress++;
                        if (currentAddress >= this.hashTable.length) {
                            return false;
                        }
                    }
                }
                this.hashTable[currentAddress] = new Slot(key, value);
                return true;
            }
        } else {
            this.hashTable[address] = new Slot(key, value);
        }
        return true;
    }

    public String getData(String key) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            if (this.hashTable[address].key == key) {
                return this.hashTable[address].value;
            } else {
                Integer currentAddress = address + 1;
                while (this.hashTable[currentAddress] != null) {
                    if (this.hashTable[currentAddress].key == key) {
                        return this.hashTable[currentAddress].value;
                    } else {
                        currentAddress++;
                        if (currentAddress >= this.hashTable.length) {
                            return null;
                        }
                    }
                }
                return null;
            }
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        MyHash_LinearProbing mainObject = new MyHash_LinearProbing(20);
        mainObject.saveData("DaveLee", "01022223333");
        mainObject.saveData("fun-coding", "0103333444");
        mainObject.saveData("David", "01044445555");
        mainObject.saveData("Dave", "01055556666");
        mainObject.getData("David");
    }
}

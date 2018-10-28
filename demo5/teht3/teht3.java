class Humppa extends Musiikki {...}

class Musiiki extends Viihde {...}

class Viihde {...}

class Eläkeläinen extends Muusikko {...}

class Muusikko extends Viihdetaiteilija {...}

class Viihdetaiteilija {...}

class HumppaFani extends MusiikinKuuntelija {...}

class MusiikinKuuntelija extends KaikkiRuokainen {...}

class Kaikkiruokainen {...}

// Geneeriset tuottajat:

class Viihdetaiteilija<T> {
    public <T extends Viihde> tuota() {...}
}

class Muusikko<T> {
    public <T extends Musiikki> tuota() {...}
}

class Eläkeläinen<T> {
    public <T extends Humppa> tuota() {...}
}

// Geneeriset kuluttajat:

class Kaikkiruokainen<T> {
    public void kuluta(<T extends Viihde>) {...}
}

    class MusiikinKuuntelija<T> {
    public void kuluta(<T extends Musiikki>) {...}
}

        class HumppaFani<T> {
    public void kuluta(<T extends Humppa>) {...}
}
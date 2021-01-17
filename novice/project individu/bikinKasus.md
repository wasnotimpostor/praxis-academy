Membuat sistem penjualan toko X Ada beberapa cabang toko

Tabel :
> cabang_toko(join table) : id_toko, nama_toko, alamat_toko
> toko_a : id_toko, nama_toko, alamat_toko, id_barang, nama_barang, harga_barang, stok_barang
> toko_b : id_toko, nama_toko, alamat_toko, id_barang, nama_barang, harga_barang, stok_barang
> toko_c : id_toko, nama_toko, alamat_toko, id_barang, nama_barang, harga_barang, stok_barang
> penjualan : id_transaksi, id_barang, asal_toko, harga_barang, jumlah_jual
> barang : id_barang, nama_barang, harga_barang

Role :
> owner : id, nama, username, password
> bm_a : id, nama, username, password
> bm_b
> bm_c
> pembeli

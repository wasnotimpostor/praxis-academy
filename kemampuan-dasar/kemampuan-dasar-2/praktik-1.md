# 1. Alice membuat proyek baru
Membuat repository lokal, README, dan commit.

	evan@evan-GL552VX:~$ mkdir rhymes
	evan@evan-GL552VX:~$ cd rhymes
	evan@evan-GL552VX:~/rhymes$ git init
	Initialized empty Git repository in /home/evan/rhymes/.git/
	evan@evan-GL552VX:~/rhymes$ touch README.txt
	evan@evan-GL552VX:~/rhymes$ git add README.txt
	evan@evan-GL552VX:~/rhymes$ git commit -m 'first commit'
	[master (root-commit) 72565b6] first commit
	 1 file changed, 0 insertions(+), 0 deletions(-)
	 create mode 100644 README.txt
	evan@evan-GL552VX:~/rhymes$ echo 'This repo is a collection of my favorite nursery rhymes.' >> README.txt
	evan@evan-GL552VX:~/rhymes$ git status
	On branch master
	Changes not staged for commit:
	  (use "git add <file>..." to update what will be committed)
	  (use "git restore <file>..." to discard changes in working directory)
		modified:   README.txt

	no changes added to commit (use "git add" and/or "git commit -a")
	evan@evan-GL552VX:~/rhymes$ git diff
	diff --git a/README.txt b/README.txt
	index e69de29..c83e022 100644
	--- a/README.txt
	+++ b/README.txt
	@@ -0,0 +1 @@
	+This repo is a collection of my favorite nursery rhymes.
	evan@evan-GL552VX:~/rhymes$ git add README.txt
	evan@evan-GL552VX:~/rhymes$ git commit -m 'Added project overview to README.txt'
	[master 7846df1] Added project overview to README.txt
	 1 file changed, 1 insertion(+)

### file tidak bisa didownload jadi harus bikin file nya sendiri
Link file :

	wget https://www.acquia.com/sites/default/files/blog/all-around-the-mulberry-bush.txt
	wget https://www.acquia.com/sites/default/files/blog/jack-and-jill.txt
	wget https://www.acquia.com/sites/default/files/blog/old-mother-hubbard.txt
	wget https://www.acquia.com/sites/default/files/blog/twinkle-twinkle.txt
	wget https://www.acquia.com/sites/default/files/blog/hokey-pokey.txt 
	
Selanjutnya, menambahkan file tersebut dengan **git add**
	
	evan@evan-GL552VX:~/rhymes$ git add all-around-the-mulberry-bush.txt
	evan@evan-GL552VX:~/rhymes$ git status
	On branch master
	Changes to be committed:
	  (use "git restore --staged <file>..." to unstage)
		new file:   all-around-the-mulberry-bush.txt

	Untracked files:
	  (use "git add <file>..." to include in what will be committed)
		hokey-pokey.txt
		jack-and-jill.txt
		old-mother-hubbard.txt
		twinkle-twinkle.txt

	evan@evan-GL552VX:~/rhymes$ git commit -m 'Added all-around-the-mulberry-bush.txt.'
	[master 443dbd8] Added all-around-the-mulberry-bush.txt.
	 1 file changed, 20 insertions(+)
	 create mode 100644 all-around-the-mulberry-bush.txt
	evan@evan-GL552VX:~/rhymes$ git add jack-and-jill.txt
	evan@evan-GL552VX:~/rhymes$ git commit -m 'Added jack-and-jill.txt.'
	[master ae8601e] Added jack-and-jill.txt.
	 1 file changed, 13 insertions(+)
	 create mode 100644 jack-and-jill.txt
	evan@evan-GL552VX:~/rhymes$ git add .
	evan@evan-GL552VX:~/rhymes$ git commit -m 'Added old-mother-hubbard.txt, twinkle-twinkle.txt, hokey-pokey.txt' 
	[master 506c890] Added old-mother-hubbard.txt, twinkle-twinkle.txt, hokey-pokey.txt
	 3 files changed, 57 insertions(+)
	 create mode 100644 hokey-pokey.txt
	 create mode 100644 old-mother-hubbard.txt
	 create mode 100644 twinkle-twinkle.txt

Kemudian melihat hasilnya dengan git log

	evan@evan-GL552VX:~/rhymes$ git log
	commit 506c8903358c960ab74003413ed7385bcb344304 (HEAD -> master)
	Author: Evan Mahendra <evan.mahendra95@gmail.com>
	Date:   Mon Nov 23 18:34:47 2020 +0700

	    Added old-mother-hubbard.txt, twinkle-twinkle.txt, hokey-pokey.txt

	commit ae8601ea26a5f628090252cbb8b923320083809a
	Author: Evan Mahendra <evan.mahendra95@gmail.com>
	Date:   Mon Nov 23 18:34:19 2020 +0700

	    Added jack-and-jill.txt.

	commit 506c8903358c960ab74003413ed7385bcb344304 (HEAD -> master)
	Author: Evan Mahendra <evan.mahendra95@gmail.com>
	Date:   Mon Nov 23 18:34:47 2020 +0700

	    Added old-mother-hubbard.txt, twinkle-twinkle.txt, hokey-pokey.txt

	commit ae8601ea26a5f628090252cbb8b923320083809a
	Author: Evan Mahendra <evan.mahendra95@gmail.com>
	Date:   Mon Nov 23 18:34:19 2020 +0700

	    Added jack-and-jill.txt.


	commit ae8601ea26a5f628090252cbb8b923320083809a
	Author: Evan Mahendra <evan.mahendra95@gmail.com>
	Date:   Mon Nov 23 18:34:19 2020 +0700

	    Added jack-and-jill.txt.


	commit 443dbd8f734038fabc43385a049add62a0c5d9df
	Author: Evan Mahendra <evan.mahendra95@gmail.com>
	Date:   Mon Nov 23 18:33:58 2020 +0700

	    Added all-around-the-mulberry-bush.txt.

	commit 7846df15534dc29e170bb77e802f9103df60d2f3
	Author: Evan Mahendra <evan.mahendra95@gmail.com>
	Date:   Mon Nov 23 14:54:30 2020 +0700

	    Added project overview to README.txt

	commit 72565b6ef07df5056ca6be5594f94433d537898e
	Author: Evan Mahendra <evan.mahendra95@gmail.com>
	Date:   Mon Nov 23 14:52:02 2020 +0700

	    first commit


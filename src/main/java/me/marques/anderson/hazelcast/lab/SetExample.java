package me.marques.anderson.hazelcast.lab;

import java.io.Serializable;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ISet;

public class SetExample implements Serializable{

	private static final long serialVersionUID = -7519397992494663335L;

	public static void main(String[] args) {
		new SetExample().run();
	}
		
		
	private void run() {
		HazelcastInstance hz = Hazelcast.newHazelcastInstance();
		
		// Cache namespace -> "best-movies"
		ISet<Movie> bestMovies = hz.getSet("best-movies");
		
		
		bestMovies.add(new Movie("Steven Spielberg", "Shark", 1975));
		bestMovies.add(new Movie("Steven Spielberg", "Jurassic Park", 1993));
		bestMovies.add(new Movie("Peter Jackson", "The Lord of The Rings", 2001));
		bestMovies.add(new Movie("Peter Jackson", "The Lord of The Rings", 2001)); // Duplicated Entry
		bestMovies.add(new Movie("Peter Foo", "The Lord of The Rings", 2001)); // Equals will act. Same name, another author.
		
		
		ISet<Movie> myBestMovies = hz.getSet("best-movies");
		
		for (Movie m : myBestMovies){
			System.out.println(m);
		}
	}
	
	class Movie implements Serializable {
		private static final long serialVersionUID = 8892624720196112139L;
		
		final String author;
		final String title;
		final Integer year;
		
		public Movie(String author, String title, Integer year) {
			this.author = author;
			this.title = title;
			this.year = year;
		}
		
		@Override
		public String toString() {
			return "Movie [author=" + author + ", title=" + title + ", year=" + year + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((author == null) ? 0 : author.hashCode());
			result = prime * result + ((title == null) ? 0 : title.hashCode());
			result = prime * result + ((year == null) ? 0 : year.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Movie other = (Movie) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (author == null) {
				if (other.author != null)
					return false;
			} else if (!author.equals(other.author))
				return false;
			if (title == null) {
				if (other.title != null)
					return false;
			} else if (!title.equals(other.title))
				return false;
			if (year == null) {
				if (other.year != null)
					return false;
			} else if (!year.equals(other.year))
				return false;
			return true;
		}
		private SetExample getOuterType() {
			return SetExample.this;
		}
	}
}



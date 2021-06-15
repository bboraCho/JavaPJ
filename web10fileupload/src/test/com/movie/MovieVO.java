package test.com.movie;

import java.util.Date;

public class MovieVO {

	private int movieNum;
	private String movieTitle;
	private String movieDirector;
	private String movieWriter;
	private String movietheatherPlace;
	private String movieTheaterNum;
	private String moviePeopleNum;
	private String movieSeatNum;
	private String movieJanre;
	private Date movieDate;
	private String movieFileName;
	
	public int getMovieNum() {
		return movieNum;
	}

	public void setMovieNum(int movieNum) {
		this.movieNum = movieNum;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public String getMovieDirector() {
		return movieDirector;
	}

	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}

	public String getMovieWriter() {
		return movieWriter;
	}

	public void setMovieWriter(String movieWriter) {
		this.movieWriter = movieWriter;
	}

	public String getMovietheatherPlace() {
		return movietheatherPlace;
	}

	public void setMovietheatherPlace(String movietheatherPlace) {
		this.movietheatherPlace = movietheatherPlace;
	}

	public String getMovieTheaterNum() {
		return movieTheaterNum;
	}

	public void setMovieTheaterNum(String movieTheaterNum) {
		this.movieTheaterNum = movieTheaterNum;
	}

	public String getMoviePeopleNum() {
		return moviePeopleNum;
	}

	public void setMoviePeopleNum(String moviePeopleNum) {
		this.moviePeopleNum = moviePeopleNum;
	}

	public String getMovieSeatNum() {
		return movieSeatNum;
	}

	public void setMovieSeatNum(String movieSeatNum) {
		this.movieSeatNum = movieSeatNum;
	}

	public String getMovieJanre() {
		return movieJanre;
	}

	public void setMovieJanre(String movieJanre) {
		this.movieJanre = movieJanre;
	}

	public Date getMovieDate() {
		return movieDate;
	}

	public void setMovieDate(Date movieDate) {
		this.movieDate = movieDate;
	}

	public String getMovieFileName() {
		return movieFileName;
	}

	public void setMovieFileName(String movieFileName) {
		this.movieFileName = movieFileName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((movieDate == null) ? 0 : movieDate.hashCode());
		result = prime * result + ((movieDirector == null) ? 0 : movieDirector.hashCode());
		result = prime * result + ((movieFileName == null) ? 0 : movieFileName.hashCode());
		result = prime * result + ((movieJanre == null) ? 0 : movieJanre.hashCode());
		result = prime * result + movieNum;
		result = prime * result + ((moviePeopleNum == null) ? 0 : moviePeopleNum.hashCode());
		result = prime * result + ((movieSeatNum == null) ? 0 : movieSeatNum.hashCode());
		result = prime * result + ((movieTheaterNum == null) ? 0 : movieTheaterNum.hashCode());
		result = prime * result + ((movieTitle == null) ? 0 : movieTitle.hashCode());
		result = prime * result + ((movieWriter == null) ? 0 : movieWriter.hashCode());
		result = prime * result + ((movietheatherPlace == null) ? 0 : movietheatherPlace.hashCode());
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
		MovieVO other = (MovieVO) obj;
		if (movieDate == null) {
			if (other.movieDate != null)
				return false;
		} else if (!movieDate.equals(other.movieDate))
			return false;
		if (movieDirector == null) {
			if (other.movieDirector != null)
				return false;
		} else if (!movieDirector.equals(other.movieDirector))
			return false;
		if (movieFileName == null) {
			if (other.movieFileName != null)
				return false;
		} else if (!movieFileName.equals(other.movieFileName))
			return false;
		if (movieJanre == null) {
			if (other.movieJanre != null)
				return false;
		} else if (!movieJanre.equals(other.movieJanre))
			return false;
		if (movieNum != other.movieNum)
			return false;
		if (moviePeopleNum == null) {
			if (other.moviePeopleNum != null)
				return false;
		} else if (!moviePeopleNum.equals(other.moviePeopleNum))
			return false;
		if (movieSeatNum == null) {
			if (other.movieSeatNum != null)
				return false;
		} else if (!movieSeatNum.equals(other.movieSeatNum))
			return false;
		if (movieTheaterNum == null) {
			if (other.movieTheaterNum != null)
				return false;
		} else if (!movieTheaterNum.equals(other.movieTheaterNum))
			return false;
		if (movieTitle == null) {
			if (other.movieTitle != null)
				return false;
		} else if (!movieTitle.equals(other.movieTitle))
			return false;
		if (movieWriter == null) {
			if (other.movieWriter != null)
				return false;
		} else if (!movieWriter.equals(other.movieWriter))
			return false;
		if (movietheatherPlace == null) {
			if (other.movietheatherPlace != null)
				return false;
		} else if (!movietheatherPlace.equals(other.movietheatherPlace))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MovieVO [movieNum=" + movieNum + ", movieTitle=" + movieTitle + ", movieDirector=" + movieDirector
				+ ", movieWriter=" + movieWriter + ", movietheatherPlace=" + movietheatherPlace + ", movieTheaterNum="
				+ movieTheaterNum + ", moviePeopleNum=" + moviePeopleNum + ", movieSeatNum=" + movieSeatNum
				+ ", movieJanre=" + movieJanre + ", movieDate=" + movieDate + ", movieFileName=" + movieFileName + "]";
	}

}





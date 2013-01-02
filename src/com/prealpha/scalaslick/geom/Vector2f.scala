package com.prealpha.scalaslick.geom

import org.newdawn.slick.util.FastTrig
import javax.xml.bind.annotation.XmlInlineBinaryData

/**
 * A two dimensional vector
 *
 * @author Kevin Glass
 *         With changes by Ty Overby
 */

object vector2fConversions{
    @inline
    implicit def tupleToVector2f(tuple: (Float, Float)) = new Vector2f(tuple._1, tuple._2)

    @inline
    implicit def vector2fToTuple(vector: Vector2f) = (vector.x, vector.y)
}
case class Vector2f(var x: Float, var y: Float) {


    /**
     * Create a new vector based on an angle
     *
     * @param theta The angle of the vector in degrees
     */
    def this(theta: Double) {
        this(1f, 0f)
        setTheta(theta)
    }

    /**
     * Calculate the components of the vectors based on a angle
     *
     * @param t The angle to calculate the components from (in degrees)
     */
    def setTheta(t: Double) {
        var theta = t

        if ((theta < -360) || (theta > 360)) {
            theta = theta % 360
        }
        if (theta < 0) {
            theta = 360 + theta
        }
        var oldTheta: Double = getTheta
        if ((theta < -360) || (theta > 360)) {
            oldTheta = oldTheta % 360
        }
        if (theta < 0) {
            oldTheta = 360 + oldTheta
        }
        val len: Float = length
        x = len * FastTrig.cos(StrictMath.toRadians(theta)).asInstanceOf[Float]
        y = len * FastTrig.sin(StrictMath.toRadians(theta)).asInstanceOf[Float]
    }

    /**
     * Adjust this vector by a given angle
     *
     * @param theta
	 * The angle to adjust the angle by (in degrees)
     * @return This vector - useful for chaining operations
     *
     */
    def addTheta(theta: Double): Vector2f = {
        setTheta(getTheta + theta)
        this
    }

    /**
     * Adjust this vector by a given angle
     *
     * @param theta The angle to adjust the angle by (in degrees)
     * @return This vector - useful for chaining operations
     */
    def subTheta(theta: Double): Vector2f = {
        setTheta(getTheta - theta)
        this
    }

    /**
     * Get the angle this vector is at
     *
     * @return The angle this vector is at (in degrees)
     */
    def getTheta: Double = {
        var theta: Double = StrictMath.toDegrees(StrictMath.atan2(y, x))
        if ((theta < -360) || (theta > 360)) {
            theta = theta % 360
        }
        if (theta < 0) {
            theta = 360 + theta
        }
        theta
    }

    /**
     * Create a new vector based on another
     *
     * @param other The other vector to copy into this one
     */
    def this(other: Vector2f) {
        this(other.x, other.y)
    }

    /**
     * Set the value of this vector
     *
     * @param other The values to set into the vector
     */
    def set(other: Vector2f) {
        set(other.x, other.x)
    }

    /**
     * Dot this vector against another
     *
     * @param other The other vector dot against
     * @return The dot product of the two vectors
     */
    def dot(other: Vector2f): Float = (x * other.x) + (y * other.x)

    /**
     * An alias for the dot product: Vector2f.dot
     */
    def * (other: Vector2f) = this.dot _


    /**
     * Set the values in this vector
     *
     * @param x The x component to set
     * @param y The y component to set
     * @return This vector - useful for chaining operations
     */
    def set(x: Float, y: Float): Vector2f = {
        this.x = x
        this.y = y
        this
    }

    /**
     * A vector perpendicular to this vector.
     *
     * @return a vector perpendicular to this vector
     */
    def getPerpendicular: Vector2f = {
        new Vector2f(-y, x)
    }

    /**
     * Set the values in this vector
     *
     * @param pt The pair of values to set into the vector
     * @return This vector - useful for chaining operations
     */
    def set(pt: Array[Float]): Vector2f = {
        set(pt(0), pt(1))
    }

    /**
     * Negate this vector
     *
     * @return A copy of this vector negated
     */
    def negate: Vector2f = {
        new Vector2f(-x, -y)
    }
    def unary_- = negate

    /**
     * Negate this vector without creating a new copy
     *
     * @return This vector - useful for chaning operations
     */
    def negateLocal: Vector2f = {
        x = -x
        y = -y
        this
    }

    /**
     * Add a vector to this vector.
     *
     * This operation is modifying
     * @param v The vector to add
     * @return This vector - useful for chaning operations
     */
    def add(v: Vector2f): Vector2f = {
        x += v.x
        y += v.y
        this
    }

    /**
     * An alias for Vector2f.add
     */
    def += = add _

    /**
     * Copies this vector and adds it with the other
     *
     * This operation is <em> not </em> modifying
     * @param other The vector to add
     * @return A modified copy
     */
    def plus(other: Vector2f): Vector2f = this.copy.add(other)

    /**
     * An alias for Vector2f.plus
     */
    def +  = this.plus _

    /**
     * Subtract a vector from this vector
     *
     * This operation is modifying
     * @param v The vector subtract
     * @return This vector - useful for chaining operations
     */
    def sub(v: Vector2f): Vector2f = {
        x -= v.x
        y -= v.y
        this
    }

    /**
     * An alias for Vector2f.sub
     */
    def -= = sub _

    /**
     * Create a copy of this vector and subtract a vector from it
     *
     * This operation is <em> not <em> modifying
     * @param other The vector to subtract
     * @return A copy vector after subtraction
     */
    def minus(other: Vector2f): Vector2f = this.copy.sub(other)

    /**
     * An alias for Vector2f.minus
     */
    def - = this.minus _

    /**
     * Scale this vector by a value
     *
     * This operation is modifying
     * @param a The value to scale this vector by
     * @return This vector - useful for chaining operations
     */
    def scale(a: Float): Vector2f = {
        x *= a
        y *= a
        this
    }

    /**
     * An alias for Vector2f.scale
     * @return
     */
    def *= = scale _

    /**
     * Copies this vector and scales it according to a scalar
     *
     * This operation is <em> not <em> modifying
     * @param a The scalar to change with
     * @return A scaled copy of this vector
     */
    def scaled(a: Float): Vector2f = this.copy.scale(a)

    /**
     * An alias for Vector2f.scaled
     */
    def * = scaled _

    /**
     * Scale this vector by the inverse of the scalar
     *
     * This operation is modifying
     * @param scalar The scalar to modify the value of
     * @return
     */
    def divide(scalar: Float) = scale(1/scalar)

    /**
     * An alias for Vector2f.divide
     */
    def /= = divide _

    /**
     * Return a copy of this vector that is scaled with the
     * inverse of the scalar provided
     *
     * This operation is <em> not </em> modifying
     * @param scalar The scalar to modify the vector with
     * @return A copy of this vector with a scaled length
     */
    def over(scalar: Float) = this.copy.divide(scalar)

    /**
     * An alias of Vector2f.over
     */
    def / = over _

    /**
     * Normalise the vector
     *
     * This operation is modifying
     * @return This vector - useful for chaning operations
     */
    def normalise: Vector2f = {
        val l: Float = length
        if (l == 0) {
            return this
        }
        x /= l
        y /= l
        this
    }

    /**
     * The normal of the vector
     *
     * This operation is <not> modifying
     * @return A unit vector with the same direction as the vector
     */
    def getNormal: Vector2f = {
        val cp: Vector2f = copy
        cp.normalise
        cp
    }

    /**
     * The length of the vector squared
     *
     * @return The length of the vector squared
     */
    def lengthSquared: Float = (x * x) + (y * y)


    /**
     * Get the length of this vector
     *
     * @return The length of this vector
     */
    def length: Float = {
        math.sqrt(lengthSquared).toFloat
    }

    /**
     * Project this vector onto another
     *
     * @param b The vector to project onto
     * @param result The projected vector
     */
    def projectOntoUnit(b: Vector2f, result: Vector2f) {
        val dp: Float = b.dot(this)
        result.x = dp * b.x
        result.y = dp * b.y
    }

    /**
     * Return a copy of this vector
     *
     * @return The new instance that copies this vector
     */
    def copy: Vector2f = {
        new Vector2f(x, y)
    }

    /**
     * @see java.lang.Object#toString()
     */
    override def toString: String = {
        "[Vector2f " + x + "," + y + " (" + length + ")]"
    }

    /**
     * Get the distance from this point to another
     *
     * @param other The other point we're measuring to
     * @return The distance to the other point
     */
    def distance(other: Vector2f): Float = {
        math.sqrt(distanceSquared(other)).asInstanceOf[Float]
    }

    /**
     * Get the distance from this point to another, squared. This
     * can sometimes be used in place of distance and avoids the
     * additional sqrt.
     *
     * @param other The other point we're measuring to
     * @return The distance to the other point squared
     */
    def distanceSquared(other: Vector2f): Float = {
        val dx: Float = other.x - x
        val dy: Float = other.y - y

        (dx * dx) + (dy * dy)
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    override def hashCode: Int = {
        997 * (x.toInt) ^ 991 * (y.toInt)
    }

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    override def equals(other: Any): Boolean = {
        if (other.isInstanceOf[Vector2f]) {
            val o: Vector2f = (other.asInstanceOf[Vector2f])
            return (o.x == x) && (o.y == y)
        }
        false
    }
}

